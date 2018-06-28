package com.dagemen.client;

import org.junit.Test;

public class RunSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("执行顺序:"+fun1()+"----"+fun2());
        int i = 1;
        System.out.println(i++ +"---"+ ++i);
    }

    public static int fun1(){
        System.out.println(1);
        return 1;
    }

    public static int fun2(){
        System.out.println(2);
        return 2;
    }

    @Test
    public void testSequence() {
        int a = 1<0 ? 2 : 3>6 ? 4 : 5;
        System.out.println(a);
    }
}
