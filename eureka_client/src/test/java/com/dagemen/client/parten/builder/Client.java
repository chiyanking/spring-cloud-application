package com.dagemen.client.parten.builder;

public class Client {
    public static void main(String[] args) {
        InsuranceContract build = new InsuranceContract
                .ConcreteBuilder("123123", System.nanoTime(), System.nanoTime())//重要参数 需要必传参数
                .setCompanyName("zangsan").setOtherData("sfasdf").setPersonName("里斯")//可以选择传入测参数
                .build();//

    }
}
