package com.patterns.usage.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {

    protected Map<Integer, String> orders = new HashMap();
    protected TeaMaker teaMaker;

    TeaShop(TeaMaker teaMaker)
    {
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, Integer table)
    {
        this.orders.put(table,this.teaMaker.make(teaType));
    }

    public void serve()
    {
        for (Map.Entry<Integer, String> order: orders.entrySet()) {
        System.out.format("Serving %s tea to table %d\n",order.getValue(),order.getKey());
    }
    }
}
