package com.dagemen.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);

    Semaphore semaphore = new Semaphore(5);


    @Test
    public void testSemaphore() throws InterruptedException {
        while (true) {
            logger.info("线程{}占据一个型号量", Thread.currentThread().getName());
            semaphore.acquire(1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        logger.info("线程{}释放一个型号量", Thread.currentThread().getName());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }

    @Test
    public void testJoin() throws InterruptedException {

        logger.info("{} start", Thread.currentThread().getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("{} start", Thread.currentThread().getName());
                    logger.info("{} sleep", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    logger.info("{} end", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        logger.info("{} end", Thread.currentThread().getName());
    }
}
