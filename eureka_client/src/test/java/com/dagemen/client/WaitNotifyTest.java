package com.dagemen.client;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyTest {

    @Test
    public void testNotify() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(false);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (reentrantLock) {
                        reentrantLock.notify();
                    }
                }
            }
        });
        thread.start();

        if (!reentrantLock.isLocked()) {
            synchronized (reentrantLock) {
                System.out.println(Thread.holdsLock(reentrantLock));
                reentrantLock.wait();
            }
            System.out.println("reentrantLock is lock : " + Thread.holdsLock(reentrantLock));
        }
    }
}
