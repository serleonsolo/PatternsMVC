package com.patterns.controller;

public enum PatternFilter
{
    NAME("name"),
    DESCRIPTION("description"),
    PATTERN_TYPE("patternType"),
    IS_USED("isMain"),
    MIN_RATING("minRating"),
    MAX_RATING("maxRating"),
    ORDER("order"),
    PAGE_NUMBER("pageNumber"),
    PAGE_SIZE("pageSize"),
    ;

    private String fieldName;

    PatternFilter(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
