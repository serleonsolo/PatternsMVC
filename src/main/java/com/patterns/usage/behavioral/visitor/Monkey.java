package com.patterns.usage.behavioral.visitor;

import com.patterns.utils.PatternHelper;

public class Monkey implements Animal {

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitMonkey(this);
    }

    public void shout() {
        PatternHelper.print("Monkey Shouts");
    }
}
