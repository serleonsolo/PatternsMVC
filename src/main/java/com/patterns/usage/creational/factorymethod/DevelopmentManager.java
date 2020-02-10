package com.patterns.usage.creational.factorymethod;

public class DevelopmentManager extends HiringManager {

    @Override
    public Interviewer makeInterviewer() {
        return new Developer();
    }
}
