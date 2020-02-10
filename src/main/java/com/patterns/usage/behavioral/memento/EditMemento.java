package com.patterns.usage.behavioral.memento;

public class EditMemento {

    protected String content;

    public EditMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
