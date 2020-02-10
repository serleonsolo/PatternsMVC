package com.patterns.controller;

public enum PatternOrder {
    ID("id"), // default
    TYPE("type"),
    RATING("rating");

    private String fieldName;

    PatternOrder(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static PatternOrder getType(String input) {
        for (PatternOrder type: PatternOrder.values()) {
            if (type.toString().equals(input)) {
                return type;
            }
        }
        throw new RuntimeException("unknown type");
    }
}