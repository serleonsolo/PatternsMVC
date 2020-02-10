package com.patterns.usage.creational.additional.simplefactory;

import com.patterns.usage.AbstractPatternUsage;

public class SimpleFactoryUsage extends AbstractPatternUsage {

    public SimpleFactoryUsage() {
        this.description = "Простая фабрика просто генерирует экземпляр для клиента без предоставления какой-либо логики экземпляра.";
    }

    @Override
    public void demonstrate()
    {
        log.append("Generate Wooden Door by Door Factory !\n");
        Door door = DoorFactory.makeDoor(10,15);
    }
}
