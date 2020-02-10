package com.patterns.usage.behavioral.memento;

import com.patterns.usage.AbstractPatternUsage;

public class MementoUsage extends AbstractPatternUsage {

    public MementoUsage() {
        this.description = "Шаблон подразумевает сохранение текущего состояния объекта с возможностью восстановления.";
    }

    @Override
    public void demonstrate() {
        Editor editor = new Editor();
        editor.type("First Line\n");
        editor.type("Second Line\n");
        EditMemento editMemento = editor.save();
        editor.type("Third Line\n");
        editor.print();
        editor.restore(editMemento);
        editor.print();
    }
}
