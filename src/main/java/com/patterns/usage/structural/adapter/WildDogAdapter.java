package com.patterns.usage.structural.adapter;

import com.patterns.utils.PatternHelper;

public class WildDogAdapter implements Lion {

    protected WildDog dog;

    public WildDogAdapter(WildDog dog) {
        PatternHelper.print("Convert Wild Dog to Lion");
        this.dog = dog;
    }

    @Override
    public void roar() {

    }
}
