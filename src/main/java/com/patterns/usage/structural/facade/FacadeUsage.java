package com.patterns.usage.structural.facade;

import com.patterns.usage.AbstractPatternUsage;

public class FacadeUsage extends AbstractPatternUsage {

    public FacadeUsage() {
        this.description = "Шаблон «Фасад» предоставляет упрощённый интерфейс для сложной подсистемы.\n";
        ;
    }

    @Override
    public void demonstrate() {
        ComputerFacade computerFacade = new ComputerFacade(new Computer());
        computerFacade.turnOn();
        computerFacade.turnOff();
    }
}
