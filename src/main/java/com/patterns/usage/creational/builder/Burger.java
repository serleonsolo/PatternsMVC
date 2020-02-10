package com.patterns.usage.creational.builder;

public class Burger {

    protected int size;

    protected boolean cheese = false;
    protected boolean pepperoni = false;
    protected boolean letuce = false;
    protected boolean tomato = false;

    public Burger(BurgerBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.letuce = builder.letuce;
        this.tomato = builder.tomato;
    }
}
