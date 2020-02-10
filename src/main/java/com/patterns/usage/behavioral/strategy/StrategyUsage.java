package com.patterns.usage.behavioral.strategy;

import com.patterns.usage.AbstractPatternUsage;

public class StrategyUsage extends AbstractPatternUsage {

    public StrategyUsage() {
        this.description = "Шаблон подразумевает переключение между алгоритмами или стратегиями в зависимости от истуации.";
    }

    @Override
    public void demonstrate() {
        SortingStrategy bubbleSortStrategy = new BubbleSortStrategy();
        SortingStrategy quickSortingStrategy = new QuickSortingStrategy();
        int[] array = {1,2,34,34,2};
        int[] array1 = new Sorter(bubbleSortStrategy).sort(array);
        int[] array2 = new Sorter(quickSortingStrategy).sort(array);
    }
}
