package com.patterns.usage.behavioral.visitor;

import com.patterns.utils.PatternHelper;

public class Lion implements Animal {

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitLion(this);
    }

    public void roar()
    {
        PatternHelper.print("Lion Roars");
    }
}
