package com.patterns.usage.behavioral.visitor;

import com.patterns.utils.PatternHelper;

public class Jump implements AnimalOperation {

    @Override
    public void visitMonkey(Monkey monkey) {
        PatternHelper.print("Monkey Jumps");
    }

    @Override
    public void visitLion(Lion lion) {
        PatternHelper.print("Lion Jumps");
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        PatternHelper.print("Dolphin Jumps");
    }
}
