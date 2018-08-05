package com.dagemen.client.parten.builder;

public class Pizza {
    Pizza orderPizza(String type) {
        Pizza pizza = null;
        if ("chesse".equals(type)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        } else if ("pepperonpi".equals(type)) {
            pizza = new Pizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


    public void prepare() {

    }

    public void bake() {

    }

    public void cut() {

    }

    public void box() {

    }
}


class CheesePizza extends Pizza {

}

class GreekPizza extends Pizza {

}

class PepperoniPizza extends Pizza {

}
