package com.patterns.repository;

import com.patterns.model.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternRepository extends JpaRepository<Pattern, Long> {
}
