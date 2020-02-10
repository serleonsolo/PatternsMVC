package com.patterns.usage.creational.singleton;

public class President {
    private static President instance;

    public President() {
    }

    public static President getInstance()
    {
        if(instance == null)
        {
            return instance = new President();
        }
        else
        {
            return instance;
        }
    }
}