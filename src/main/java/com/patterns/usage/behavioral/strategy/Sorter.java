package com.patterns.usage.behavioral.strategy;

public class Sorter {

    SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public int[] sort(int[] array)
    {
        return sortingStrategy.sort(array);
    }
}
