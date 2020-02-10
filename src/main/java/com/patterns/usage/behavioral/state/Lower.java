package com.patterns.usage.behavioral.state;

import com.patterns.utils.PatternHelper;

public class Lower implements WritingState {

    @Override
    public void write(String text) {
        PatternHelper.print(text.toLowerCase());
    }

    @Override
    public String getName() {
        return "Lower Case";
    }
}
