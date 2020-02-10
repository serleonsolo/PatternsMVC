package com.patterns.usage.creational.abstractfactory;

import com.patterns.utils.PatternHelper;

public class IronDoorFactory implements DoorFactory {

    @Override
    public Door makeDoor()
    {
        PatternHelper.print("Generate Iron Door");
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeExpert()
    {
        PatternHelper.print("Prepare Iron Expert");
        return new Welder();
    }
}
