package com.patterns.usage.creational.builder;

import com.patterns.usage.AbstractPatternUsage;

public class BuilderUsage extends AbstractPatternUsage {

    public BuilderUsage() {
        this.description = "Шаблон позволяет создавать разные свойства объекта, избегая загрязнения конструктора (constructor pollution). " +
                "\n" + "Это полезно, когда у объекта может быть несколько свойств. " +
                "\n" + "Или когда создание объекта состоит из большого количества этапов.";
    }

    @Override
    public void demonstrate() {
        Burger burger = new Burger(new BurgerBuilder(14)
                .addCheese()
                .addPepperoni()
                .addTomato()
        );
    }
}
