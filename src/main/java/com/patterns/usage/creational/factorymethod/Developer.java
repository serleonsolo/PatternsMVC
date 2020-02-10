package com.patterns.usage.creational.factorymethod;

public class Developer implements Interviewer {

    @Override
    public void askQuestions() {
        System.out.println("Developer Asking about Design Patterns !");
    }
}
