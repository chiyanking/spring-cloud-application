package com.dagemen.client.parten.single;

public class SingleInstance {

    static {
        System.out.println("SingleInstance has bean load ！");
    }

    private SingleInstance() {
    }


    public static class SingleInstanceHolder {

        static {
            System.out.println("SingleInstanceHolder has bean load ！");
        }

        public static SingleInstance instance = new SingleInstance();
    }


   public static SingleInstance getInstance() {
        System.out.println("invoke getInstance ");
        return SingleInstanceHolder.instance;
    }


    public static void main(String[] args) {

        SingleInstance instance = SingleInstance.getInstance();

    }


}
