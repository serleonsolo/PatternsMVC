package com.patterns.usage.structural.decorator;

public class SimpleCoffee implements Coffee {

    @Override
    public float getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    public void print(){
        System.out.format("Coffee with cost %f and description %s\n", this.getCost(),this.getDescription());
    }
}
