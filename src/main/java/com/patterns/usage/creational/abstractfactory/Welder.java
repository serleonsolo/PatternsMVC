package com.patterns.usage.creational.abstractfactory;

public class Welder implements DoorFittingExpert {

    @Override
    public void getDescription() {
        System.out.println("Welder can only fit iron doors");
    }
}
