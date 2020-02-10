package com.patterns.usage.creational.builder;

import com.patterns.utils.PatternHelper;

public class BurgerBuilder {

    public int size;
    public boolean cheese = false;
    public boolean pepperoni = false;
    public boolean letuce = false;
    public boolean tomato = false;

    public BurgerBuilder(int size) {
        PatternHelper.print("Burger Setting Size !");
        this.size = size;
    }

    public BurgerBuilder addCheese() {
        PatternHelper.print("Burger Adding Cheese !");
        this.cheese = true;
        return this;
    }

    public BurgerBuilder addPepperoni() {
        PatternHelper.print("Burger Adding Pepperoni !");
        this.pepperoni = true;
        return this;
    }

    public BurgerBuilder addTomato() {
        System.out.println("Burger Adding Tomato !");
        this.tomato = true;
        return this;
    }
}
