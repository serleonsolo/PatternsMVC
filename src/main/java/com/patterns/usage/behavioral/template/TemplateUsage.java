package com.patterns.usage.behavioral.template;

import com.patterns.usage.AbstractPatternUsage;

public class TemplateUsage extends AbstractPatternUsage {

    public TemplateUsage() {
        this.description = "Шаблон определяет каркас выполнения алгоритма, но реализацию самих этапов делегирует наследникам.";
    }

    @Override
    public void demonstrate() {
        WaterfallTemplate googleProject = new GoogleProject();
        googleProject.project();
        WaterfallTemplate nttProject = new NTTProject();
        nttProject.project();
    }
}
