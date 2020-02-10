package com.patterns.usage.behavioral.visitor;

public interface AnimalOperation {

    void visitMonkey(Monkey monkey);

    void visitLion(Lion lion);

    void visitDolphin(Dolphin dolphin);
}
