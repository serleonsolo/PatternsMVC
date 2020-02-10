package com.patterns.usage.creational.abstractfactory;

import com.patterns.utils.PatternHelper;

public class WoodenDoorFactory implements DoorFactory {

    @Override
    public Door makeDoor() {
        PatternHelper.print("Generate Wooden Door");
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeExpert() {
        PatternHelper.print("Generate Wooden Door");
        return new Carpenter();
    }
}
