package com.patterns.usage.structural.adapter;

import com.patterns.usage.AbstractPatternUsage;

public class AdapterUsage extends AbstractPatternUsage {

    public AdapterUsage() {
        this.description = "Шаблон «Адаптер» позволяет помещать несовместимый объект в обёртку\n" +
                    ", чтобы он оказался совместимым с другим классом."
        ;
    }

    @Override
    public void demonstrate() {
        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);

        Hunter hunter = new Hunter();
        hunter.hunt(wildDogAdapter);
    }
}
