package com.patterns.usage.structural.flyweight;

import com.patterns.usage.AbstractPatternUsage;

public class FlyweightUsage extends AbstractPatternUsage {

    public FlyweightUsage() {
        this.description = "Шаблон применяется для минимизирования использования памяти или вычислительной стоимости\n" +
                "за счёт общего использования как можно большего количества одинаковых объектов.";
        ;
    }

    @Override
    public void demonstrate() {
        TeaShop teaShop = new TeaShop(new TeaMaker());

        teaShop.takeOrder("black",1);
        teaShop.takeOrder("green",2);
        teaShop.takeOrder("white",3);

        teaShop.serve();

    }
}
