package com.patterns.usage.behavioral.visitor;

import com.patterns.usage.AbstractPatternUsage;
import com.patterns.utils.PatternHelper;

public class VisitorUsage extends AbstractPatternUsage {

    public VisitorUsage() {
        this.description = "Шаблон позволяет добавлять будущие операции объектам без их модификации.";
    }

    @Override
    public void demonstrate() {
        Animal monkey = new Monkey();
        Animal lion = new Lion();
        Animal dolphin = new Dolphin();

        PatternHelper.print("New Visitor Speak");
        AnimalOperation speak = new Speak();
        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);

        PatternHelper.print("New Visitor Jump");
        AnimalOperation jump = new Jump();
        monkey.accept(jump);
        lion.accept(jump);
        dolphin.accept(jump);
    }
}
