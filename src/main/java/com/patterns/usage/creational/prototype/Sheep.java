package com.patterns.usage.creational.prototype;

public class Sheep implements Cloneable {
    protected String name;
    protected String category;

    public Sheep(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Sheep(String name) {
        this.name = name;
        this.category = "Mountain Sheep";
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString()
    {
        return String.format("Sheep Name = %s, Category = %s", this.name, this.category);
    }
}
