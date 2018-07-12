package com.dagemen.client.current;

import org.junit.Test;

import java.util.HashMap;

public class RunSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("执行顺序:" + fun1() + "----" + fun2());
        int i = 1;
        System.out.println(i++ + "---" + ++i);
    }

    public static int fun1() {
        System.out.println(1);
        return 1;
    }

    public static int fun2() {
        System.out.println(2);
        return 2;
    }

    @Test
    public void testSequence() {
        int a = 1 < 0 ? 2 : 3 > 6 ? 4 : 5;
        System.out.println(a);
    }

    @Test
    public void testName() {
        HashMap<MyKey, String> hashMap = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            hashMap.put(new MyKey(String.valueOf(1),String.valueOf(i)),String.valueOf(i));
        }
        System.out.println(hashMap);
    }

    class MyKey {

        String key;
        String value;

        public MyKey(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyKey) {
                MyKey obj1 = (MyKey) obj;
                return key.equals(obj1.key) && value.equals(obj1.value);
            }
            return false;
        }
    }
}
