package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    @Test
    public void testCountDown() throws InterruptedException {


        int count = 5;

        CountDownLatch downLatch = new CountDownLatch(count + 1);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    downLatch.countDown();
                    Thread.sleep(1000l);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        downLatch.await();

    }
}
