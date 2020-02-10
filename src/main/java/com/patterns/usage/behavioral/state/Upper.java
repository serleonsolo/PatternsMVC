package com.patterns.usage.behavioral.state;

import com.patterns.utils.PatternHelper;

public class Upper implements WritingState {

    @Override
    public void write(String text) {
        PatternHelper.print(text.toUpperCase());
    }

    @Override
    public String getName() {
        return "Upper Case";
    }
}
