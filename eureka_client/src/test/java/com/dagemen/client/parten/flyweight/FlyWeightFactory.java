package com.dagemen.client.parten.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
    private Map<String, ConcreteFlyweight> flyWeights = new HashMap<String, ConcreteFlyweight>();

    public ConcreteFlyweight factory(String str) {
        ConcreteFlyweight flyweight = flyWeights.get(str);
        if (null == flyweight) {
            flyweight = new ConcreteFlyweight(str);
            flyWeights.put(str, flyweight);
        }
        return flyweight;
    }

    public int getFlyWeightSize() {
        return flyWeights.size();
    }

}
