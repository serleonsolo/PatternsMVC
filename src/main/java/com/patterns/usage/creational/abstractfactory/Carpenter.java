package com.patterns.usage.creational.abstractfactory;

public class Carpenter implements DoorFittingExpert {

    @Override
    public void getDescription() {
        System.out.println("Carpenter can only fit wooden doors");
    }
}
