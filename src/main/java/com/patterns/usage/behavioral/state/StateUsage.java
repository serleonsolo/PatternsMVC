package com.patterns.usage.behavioral.state;

import com.patterns.usage.AbstractPatternUsage;

public class StateUsage extends AbstractPatternUsage {

    public StateUsage() {
        this.description = "Шаблон позволяет менять поведение класса в зависимости от состояния.";
    }

    @Override
    public void demonstrate() {
        Editor editor = new Editor(new Default());
        editor.write("First Line");
        editor.setState(new Upper());
        editor.write("Second Line");
        editor.setState(new Lower());
        editor.write("Third Line");
    }
}
