package com.dagemen.client.parten.wrapper;

public class Milk extends CoffeeBean1 {
    private String description = "加了牛奶！";
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    public double getPrice() {
        return beverage.getPrice() + 20;    //20表示牛奶的价格
    }
}