package com.patterns.usage.behavioral.mediator;

public class User {

    protected String name;
    protected ChatRoomMediator chat;

    public User(String name, ChatRoomMediator chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void send(String message)
    {
        this.chat.showMessage(this,message);
    }
}
