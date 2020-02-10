package com.patterns.usage;

import com.patterns.utils.PatternHelper;

public abstract class AbstractPatternUsage {

    protected String name;
    protected String type;
    protected String description;
    protected StringBuilder log = new StringBuilder();

    public AbstractPatternUsage() {
        String[] className = getClass().getName().split("\\.");
        this.setName(className[1].toUpperCase());
        this.setType(className[0].toUpperCase());
    }

    public StringBuilder getLog() {
        return log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String use()
    {
        log.append(this.name + ": Start Pattern Demonstration\n");
        demonstrate();
        log.append(this.name + ": Stop Pattern Demonstration\n");
        return log.toString();
    }

    public abstract void demonstrate();

    public String toString()
    {
        StringBuffer sb = new StringBuffer("\n");
        sb.append("Name: ").append(this.getName()).append("\n")
          .append("Type: ").append(this.getType()).append("\n")
          .append("Description: ").append(this.getDescription()).append("\n");

        return sb.toString();
    }
}
