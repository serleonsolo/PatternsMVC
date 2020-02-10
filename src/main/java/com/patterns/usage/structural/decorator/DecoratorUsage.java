package com.patterns.usage.structural.decorator;

import com.patterns.usage.AbstractPatternUsage;

public class DecoratorUsage extends AbstractPatternUsage {

    public DecoratorUsage() {
        this.description = "Шаблон «Декоратор» позволяет во время выполнения динамически изменять поведение объекта\n" +
                ", обёртывая его в объект класса «декоратора».";
        ;
    }

    @Override
    public void demonstrate() {

        Coffee simpleCoffee = new SimpleCoffee();
        simpleCoffee.print();
        Coffee milkCoffee = new MilkCoffee(simpleCoffee);
        milkCoffee.print();
        Coffee vanillaCoffee = new VanillaCoffee(milkCoffee);
        vanillaCoffee.print();
    }
}
