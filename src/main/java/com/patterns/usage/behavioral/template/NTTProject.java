package com.patterns.usage.behavioral.template;

import com.patterns.utils.PatternHelper;

public class NTTProject extends WaterfallTemplate {

    private String name = "NTT";

    @Override
    void analysis() {
        PatternHelper.print("Analysis for project: " + name);
    }

    @Override
    void design() {
        PatternHelper.print("Design for project: " + name);
    }

    @Override
    void build() {
        PatternHelper.print("Build for project: " + name);
    }

    @Override
    void test() {
        PatternHelper.print("Test for project: " + name);
    }

    @Override
    void deploy() {
        PatternHelper.print("Deploy for project: " + name);
    }

    @Override
    void support() {
        PatternHelper.print("Support for project: " + name);
    }
}
