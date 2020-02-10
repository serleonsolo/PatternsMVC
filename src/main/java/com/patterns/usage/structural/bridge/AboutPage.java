package com.patterns.usage.structural.bridge;

public class AboutPage implements WebPage {

    protected Theme theme;

    public AboutPage(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in: " + this.theme.getColor();
    }
}
