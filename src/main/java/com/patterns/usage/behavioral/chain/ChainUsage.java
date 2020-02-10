package com.patterns.usage.behavioral.chain;

import com.patterns.usage.AbstractPatternUsage;

public class ChainUsage extends AbstractPatternUsage {

    public ChainUsage() {
        this.description = "Шаблон «Цепочка ответственности» позволяет создавать цепочки объектов. \n" +
                "Запрос входит с одного конца цепочки и движется от объекта к объекту, пока не будет найден подходящий обработчик.";
        ;
    }

    @Override
    public void demonstrate() {
        Account bank = new Bank(100f);
        Account paypal = new Paypal(200f);
        Account bitcoin = new Bitcoin(300f);

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        // Начнём с банка
        try {
            bank.pay(259f);
        }
        catch (NotEnoughMonryException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
