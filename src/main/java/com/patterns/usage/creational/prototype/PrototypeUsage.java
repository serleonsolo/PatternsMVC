package com.patterns.usage.creational.prototype;

import com.patterns.usage.AbstractPatternUsage;

public class PrototypeUsage extends AbstractPatternUsage {

    public PrototypeUsage() {
        this.description = "Объект создаётся посредством клонирования существующего объекта.";
    }

    @Override
    public void demonstrate()  {
        Sheep originalSheep = new Sheep("Original Sheep");
        Sheep clonedSheep;
        try
        {
             clonedSheep = (Sheep) originalSheep.clone();//Constructor and Serialization options are also available
        }
        catch(CloneNotSupportedException e)
        {
            System.out.format("Cloning was not successfull, message: %s", e.getMessage());
            return;
        }
        clonedSheep.setName("Cloned Sheep");

        System.out.println(originalSheep);
        System.out.println(clonedSheep);

    }
}
