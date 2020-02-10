package com.patterns.usage.behavioral.strategy;

import com.patterns.utils.PatternHelper;

public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public int[] sort(int[] array) {
        PatternHelper.print("Sort Using Bubble Sorting Strategy");
        //do smth
        return new int[0];
    }
}
