package com.patterns.usage.behavioral.memento;

import com.patterns.utils.PatternHelper;

public class Editor {

    private String content = "";

    public void type(String row)
    {
        PatternHelper.print("Add Content: " + row);
        content = content.concat(row);
    }

    public EditMemento save()
    {
        PatternHelper.print("Save Content.");
        return new EditMemento(content);
    }

    public void restore(EditMemento editMemento)
    {
        PatternHelper.print("Restore Content.");
        this.content = editMemento.getContent();
    }

    public void print()
    {
        PatternHelper.print("Print Content:");
        PatternHelper.print(content);
    }
}
