package com.patterns.usage.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TeaMaker {

    protected Map<String, KarakTea> availableTea = new HashMap();

    public String make(String preference)
    {
        if (this.availableTea.get(preference) == null) {
            this.availableTea.put(preference,new KarakTea());
        }

        return preference;
    }
}
