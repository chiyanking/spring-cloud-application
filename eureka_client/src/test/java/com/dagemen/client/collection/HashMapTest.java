package com.dagemen.client.collection;

import com.google.common.base.Function;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testHash() {

        HashMap<String, String> map = new HashMap<>();

        int key = 1;

        int value = (key=2) ^ 3>>>16;

        System.out.println("value is " + value);

    }

    static final int hash(Object key) {   //jdk1.8 & jdk1.7
        int h;
        // h = key.hashCode() 为第一步 取hashCode值
        // h ^ (h >>> 16)  为第二步 高位参与运算
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int h, int length) {  //jdk1.7的源码，jdk1.8没有这个方法，但是实现原理一样的
        return h & (length - 1);  //第三步 取模运算
    }

    @Test
    public void lamda() {
        ArrayList<String> list = new ArrayList<>();
        for (Object n: list) {
            System.out.println(n);
        }
        list.forEach((n) -> System.out.println(n));

        list.forEach(System.out::println);
        Function<Object, String> stringFunction = String::valueOf;
        String zhang = stringFunction.apply("zhang");
        System.out.println(zhang);
    }
}
