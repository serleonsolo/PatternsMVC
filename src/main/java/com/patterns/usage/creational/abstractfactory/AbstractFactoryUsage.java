package com.patterns.usage.creational.abstractfactory;

import com.patterns.usage.AbstractPatternUsage;

public class AbstractFactoryUsage extends AbstractPatternUsage {

    public AbstractFactoryUsage() {
        this.description = "Это фабрика фабрик. То есть фабрика, группирующая индивидуальные, " +
                "\n" + "но взаимосвязанные/взаимозависимые фабрики без указания для них конкретных классов."
                ;
    }

    @Override
    public void demonstrate() {
        DoorFactory woodenFactory = new WoodenDoorFactory();
        Door door1 = woodenFactory.makeDoor();
        DoorFittingExpert expert1 = woodenFactory.makeExpert();

        IronDoorFactory ironFactory = new IronDoorFactory();
        Door door2 = ironFactory.makeDoor();
        DoorFittingExpert expert2 = ironFactory.makeExpert();
    }
}
