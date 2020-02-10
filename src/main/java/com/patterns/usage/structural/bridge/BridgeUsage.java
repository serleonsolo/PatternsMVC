package com.patterns.usage.structural.bridge;

import com.patterns.usage.AbstractPatternUsage;

public class BridgeUsage extends AbstractPatternUsage {

    public BridgeUsage() {
        this.description = "Шаблон «Мост» — это предпочтение компоновки наследованию.\n" +
                "Подробности реализации передаются из одной иерархии другому объекту с отдельной иерархией.\n"
        ;
    }

    @Override
    public void demonstrate() {
        LightTheme lightTheme = new LightTheme();
        WebPage aboutPage = new AboutPage(lightTheme);
        WebPage careersPage = new CareersPage(lightTheme);

        System.out.format("About Page: %s, Careers Page: %s",aboutPage.getContent(),careersPage.getContent());
        System.out.println();
    }
}
