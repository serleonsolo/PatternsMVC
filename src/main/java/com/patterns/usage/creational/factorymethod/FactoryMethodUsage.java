package com.patterns.usage.creational.factorymethod;

import com.patterns.usage.AbstractPatternUsage;

public class FactoryMethodUsage extends AbstractPatternUsage {

    public FactoryMethodUsage() {
        this.description = "Это способ делегирования логики создания объектов (instantiation logic) дочерним классам.";
    }
    @Override
    public void demonstrate() {
        HiringManager developmentManager = new DevelopmentManager();
        developmentManager.takeInterview();

        HiringManager marketingManager = new MarketingManager();
        marketingManager.takeInterview();
    }
}
