package com.patterns.usage.structural.decorator;

public class VanillaCoffee extends SimpleCoffee implements Coffee {

    protected Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public float getCost() {
        return this.coffee.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", vanilla";
    }
}
