package com.patterns.controller;

import com.patterns.model.Pattern;
import com.patterns.repository.PatternRepository;
import com.patterns.utils.PatternHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest")
public class PatternController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final PatternOrder DEFAULT_PATTERN_ORDER = PatternOrder.ID;

    @Autowired
    private PatternRepository patternRepository;

    @GetMapping("/patterns")
    public ResponseEntity<List<Pattern>> getPatterns(@RequestParam Map<String, String> customQuery) {
        List<Pattern> listPatterns = patternRepository.findAll();

        listPatterns = PatternHelper.filter(listPatterns,customQuery);

        PatternOrder patternOrder = DEFAULT_PATTERN_ORDER;
        if(customQuery.containsKey(PatternFilter.ORDER.getFieldName()))
            patternOrder = PatternOrder.getType(customQuery.get(PatternFilter.ORDER.getFieldName()));
        listPatterns = PatternHelper.sort(listPatterns,patternOrder);

        Integer pageSize = DEFAULT_PAGE_SIZE;
        Integer pageNumber = DEFAULT_PAGE_NUMBER;
        if(customQuery.containsKey(PatternFilter.PAGE_SIZE.getFieldName()))
            pageSize = Integer.parseInt(customQuery.get(PatternFilter.PAGE_SIZE.getFieldName()));
        if(customQuery.containsKey(PatternFilter.PAGE_NUMBER.getFieldName()))
            pageNumber = Integer.parseInt(customQuery.get(PatternFilter.PAGE_NUMBER.getFieldName()));
        listPatterns = listPatterns.stream()
                    .skip(pageNumber*pageSize)
                    .limit(pageSize)
                    .collect(Collectors.toList());

        return ResponseEntity.ok().body(listPatterns);
    }

    @GetMapping("/patterns/count")
    public ResponseEntity<Integer> getPatternsCount(@RequestParam Map<String, String> customQuery) {
        List<Pattern> listPatterns = patternRepository.findAll();
        listPatterns = PatternHelper.filter(listPatterns,customQuery);
        Integer count = listPatterns.size();
        return ResponseEntity.ok().body(count);
    }

    @PostMapping("/patterns")
    public ResponseEntity<Pattern> createPattern(@RequestBody Pattern pattern) {
        if(!pattern.isValid())
            return ResponseEntity.badRequest().build();
        pattern.calculate();
        return ResponseEntity.ok().body(patternRepository.save(pattern));
    }

    @PostMapping("/patterns/{id}")
    public ResponseEntity<Pattern> update(@PathVariable("id") Long id, @RequestBody Pattern sourcePattern)
    {
        if(id <= 0)
            return ResponseEntity.badRequest().build();
        try
        {
            Pattern targetPattern = patternRepository.findById(id).get();
            targetPattern = PatternHelper.copy(sourcePattern,targetPattern);
            if(!targetPattern.isValid())
                return ResponseEntity.badRequest().build();
            return ResponseEntity.ok().body(patternRepository.save(targetPattern));
        }
        catch(NoSuchElementException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/patterns/{id}")
    public ResponseEntity<Pattern> deletePattern(@PathVariable("id") Long id) {
        if(id <= 0)
            return ResponseEntity.badRequest().build();
        try
        {
            Pattern pattern = patternRepository.findById(id).get();
            patternRepository.delete(pattern);
            return ResponseEntity.ok().build();
        }
        catch(NoSuchElementException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patterns/{id}")
    public ResponseEntity<Pattern> getPattern(@PathVariable("id") Long id) {
        if(id <= 0)
            return ResponseEntity.badRequest().build();
        try
        {
            Pattern pattern = patternRepository.findById(id).get();
            return ResponseEntity.ok().body(pattern);
        }
        catch(NoSuchElementException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patterns/show/{id}")
    public ResponseEntity<String> showPattern(@PathVariable("id") Long id) {
        if(id <= 0)
            return ResponseEntity.badRequest().build();
        try

        {
            Pattern pattern = patternRepository.findById(id).get();
            return ResponseEntity.ok().body(pattern.use());
        }
        catch(NoSuchElementException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}
