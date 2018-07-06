package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class ArrayList {
    @Test
    public void testArrayList() {
        int[] list = new int[]{123, 12, 4, 1, 2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(list);
        int i = atomicIntegerArray.addAndGet(0, 111);
        System.out.println(i);
    }
}
