package com.patterns.usage.behavioral.command;

import com.patterns.usage.AbstractPatternUsage;

public class CommandUsage extends AbstractPatternUsage {

    public CommandUsage() {
        this.description = "Шаблон «Команда» позволяет инкапсулировать действия в объекты.\n" +
                "Ключевая идея — предоставить средства отделения клиента от получателя.";
        ;
    }

    @Override
    public void demonstrate() {

        Bulb bulb = new Bulb();

        Command turnOn = new TurnOn(bulb);
        Command turnOff = new TurnOff(bulb);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.submit(turnOn);
        remoteControl.submit(turnOff);

    }
}
