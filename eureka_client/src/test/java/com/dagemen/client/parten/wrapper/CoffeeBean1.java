package com.dagemen.client.parten.wrapper;


public class CoffeeBean1 implements Beverage {
    private String description = "选了第一种咖啡豆";
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public double getPrice() {
        return 50;
    }

}
