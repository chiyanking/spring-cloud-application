package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    @Test
    public void testFairLock() throws InterruptedException {
        int count = 30;
        CountDownLatch downLatch = new CountDownLatch(count);
        ReentrantLock reentrantLock = new ReentrantLock(true);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        downLatch.await();
                        reentrantLock.lock();
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock.unlock();
                }
            });
            downLatch.countDown();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }


    @Test
    public void testUnFairLock() {

        ReentrantLock reentrantLock = new ReentrantLock(false);

    }
}
