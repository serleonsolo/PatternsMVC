package com.patterns.usage.structural.composite;

public class Designer implements Employee {

    protected String name;
    protected float salary;

    public Designer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getSallary() {
        return this.salary;
    }

    @Override
    public void setSallary(float salary) {
        this.salary = salary;
    }

}
