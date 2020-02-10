package com.patterns.usage.structural.composite;

import com.patterns.usage.AbstractPatternUsage;

public class CompositeUsage extends AbstractPatternUsage {

    public CompositeUsage() {
        this.description = "Шаблон «Компоновщик» позволяет клиентам обрабатывать отдельные объекты в едином порядке.\n";
        ;
    }

    @Override
    public void demonstrate() {
        Employee john = new Developer("John", 270000);
        Employee jane = new Developer("Jane", 200000);
        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(jane);
        System.out.format("Total net salary: %f",organization.getNetSalaries());
        System.out.println();
    }
}
