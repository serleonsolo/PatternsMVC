package com.patterns.usage.behavioral.template;

public abstract class WaterfallTemplate {

    final public void project()
    {
        analysis();
        design();
        build();
        test();
        deploy();
        support();
    };

    abstract void analysis();
    abstract void design();
    abstract void build();
    abstract void test();
    abstract void deploy();
    abstract void support();
}
