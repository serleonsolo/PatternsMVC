package com.patterns.usage.behavioral.visitor;

import com.patterns.utils.PatternHelper;

public class Dolphin implements Animal {

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitDolphin(this);
    }

    public void speak()
    {
        PatternHelper.print("Dolphin Speaks");
    }
}
