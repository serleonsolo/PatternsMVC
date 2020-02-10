package com.patterns.usage.behavioral.mediator;

import com.patterns.usage.AbstractPatternUsage;

public class MediatorUsage extends AbstractPatternUsage {

    public MediatorUsage() {
        this.description = "Шаблон подразумевает добавление стороннего объекта (посредника) для управления взаимодействия между 2 объектами\n" +
                " и уменьшения их связанности (coupling)";
    }

    @Override
    public void demonstrate() {
        ChatRoomMediator chat = new ChatRoom();
        User sergey = new User("Sergey", chat);
        User kate = new User("Kate", chat);

        sergey.send("Hello");
        kate.send("Hi, my love");
    }
}
