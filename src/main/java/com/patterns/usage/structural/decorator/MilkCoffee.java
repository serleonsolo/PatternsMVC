package com.patterns.usage.structural.decorator;

public class MilkCoffee extends SimpleCoffee implements Coffee {

    protected Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public float getCost() {
        return this.coffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", milk";
    }
}
