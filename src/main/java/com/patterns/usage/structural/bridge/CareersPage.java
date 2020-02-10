package com.patterns.usage.structural.bridge;

public class CareersPage implements WebPage {

    protected Theme theme;

    public CareersPage(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers Page in: " + this.theme.getColor();
    }
}
