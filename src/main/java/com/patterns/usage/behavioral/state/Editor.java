package com.patterns.usage.behavioral.state;

import com.patterns.utils.PatternHelper;

public class Editor {

    protected WritingState state;

    public Editor(WritingState state) {
        PatternHelper.print("Set state: " + state.getName());
        this.state = state;
    }

    public void setState(WritingState state)
    {
        PatternHelper.print("Set state: " + state.getName());
        this.state = state;
    }

    public void write(String text)
    {
        state.write(text);
    }
}
