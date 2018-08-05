package com.dagemen.client.parten.flyweight;

public class ConcreteFlyweight implements Flyweight {


    private String innerState;

    public ConcreteFlyweight(String innerState) {
        this.innerState = innerState;
    }

    @Override
    public void operation(String state) {
        System.out.println("内蕴状态：" + innerState);
        System.out.println("外蕴状态：" + state);

    }
}
