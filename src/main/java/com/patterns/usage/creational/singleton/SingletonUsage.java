package com.patterns.usage.creational.singleton;

import com.patterns.usage.AbstractPatternUsage;

public class SingletonUsage extends AbstractPatternUsage
{
    public SingletonUsage() {
        this.description = "Шаблон позволяет удостовериться, что создаваемый объект — единственный в своём классе.";
        }

    @Override
    public void demonstrate() {
        log.append("Generate the Unique Instance\n");
        President president1 = President.getInstance();
        log.append("Reuse the Existing Instance\n");
        President president2 = President.getInstance();
        if(president1 == president2)
        {
            log.append("Instances are equal\n");
        }
    }
}
