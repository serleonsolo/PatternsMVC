package com.patterns.usage.behavioral.state;

import com.patterns.utils.PatternHelper;

public class Default implements WritingState {

    @Override
    public void write(String text) {
        PatternHelper.print(text);
    }

    @Override
    public String getName() {
        return "Default";
    }
}
