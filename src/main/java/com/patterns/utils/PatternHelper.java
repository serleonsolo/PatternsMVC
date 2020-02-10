package com.patterns.utils;

import com.patterns.controller.PatternFilter;
import com.patterns.controller.PatternOrder;
import com.patterns.model.Pattern;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatternHelper {

    public static void print(String message)
    {
        System.out.println(message);
    }

    public static List<Pattern> sort(List<Pattern> listPatterns, PatternOrder shipOrder)
    {
        if(shipOrder.equals(PatternOrder.ID))
                listPatterns = listPatterns.stream()
                        .sorted((pattern1, pattern2) -> pattern1.getId().compareTo(pattern2.getId()))
                        .collect(Collectors.toList());
        else if(shipOrder.equals(PatternOrder.TYPE))
                listPatterns = listPatterns.stream()
                        .sorted((pattern1, pattern2) -> pattern1.getPatternType().compareTo(pattern2.getPatternType()))
                        .collect(Collectors.toList());
        else if(shipOrder.equals(PatternOrder.RATING))
                listPatterns = listPatterns.stream()
                        .sorted((pattern1, pattern2) -> pattern1.getRating().compareTo(pattern2.getRating()))
                        .collect(Collectors.toList());
        return listPatterns;
    }

    public static List<Pattern> filter(List<Pattern> listPatterns, Map<String, String> customQuery)
    {
        if(customQuery.containsKey(PatternFilter.NAME.getFieldName()))
        {
            String nameFilter = customQuery.get(PatternFilter.NAME.getFieldName());
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getName().contains(nameFilter))
                    .collect(Collectors.toList());
        }
        if(customQuery.containsKey(PatternFilter.DESCRIPTION.getFieldName()))
        {
            String descriptionFilter = customQuery.get(PatternFilter.DESCRIPTION.getFieldName());
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getDescription().contains(descriptionFilter))
                    .collect(Collectors.toList());
        }
        if(customQuery.containsKey(PatternFilter.PATTERN_TYPE.getFieldName()))
        {
            String patternTypeFilter = customQuery.get(PatternFilter.PATTERN_TYPE.getFieldName());
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getPatternType().toString().equals(patternTypeFilter))
                    .collect(Collectors.toList());
        }if(customQuery.containsKey(PatternFilter.IS_USED.getFieldName()))
        {
            Boolean isMainFilter = Boolean.parseBoolean(customQuery.get(PatternFilter.IS_USED.getFieldName()));
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getMain().equals(isMainFilter))
                    .collect(Collectors.toList());
        }
        if(customQuery.containsKey(PatternFilter.MIN_RATING.getFieldName()))
        {
            Double minRatingFilter = Double.parseDouble(customQuery.get(PatternFilter.MIN_RATING.getFieldName()));
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getRating() >= minRatingFilter)
                    .collect(Collectors.toList());
        }
        if(customQuery.containsKey(PatternFilter.MAX_RATING.getFieldName()))
        {
            Double maxRatingFilter = Double.parseDouble(customQuery.get(PatternFilter.MAX_RATING.getFieldName()));
            listPatterns = listPatterns.stream()
                    .filter(x -> x.getRating() <= maxRatingFilter)
                    .collect(Collectors.toList());
        }
        return listPatterns;
    }

    public static Pattern copy(Pattern sourcePattern, Pattern targetPattern)
    {
        if(sourcePattern.getName() != null)
            targetPattern.setName(sourcePattern.getName());
        if(sourcePattern.getDescription() != null)
            targetPattern.setDescription(sourcePattern.getDescription());
        if(sourcePattern.getPatternType() != null)
            targetPattern.setPatternType(sourcePattern.getPatternType());
        if(sourcePattern.getRating() != null)
            targetPattern.setRating(sourcePattern.getRating());
        if(sourcePattern.getMain() != null)
            targetPattern.setMain(sourcePattern.getMain());
        targetPattern.calculate();
        return targetPattern;
    }
}
