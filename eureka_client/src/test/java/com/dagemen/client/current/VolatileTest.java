package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {


    private static volatile int count = 0;

    private static void inc() throws InterruptedException {

        Thread.sleep(1000);
        count = count + 1;
    }

    @Test
    public void testThread() throws InterruptedException {


        int ThreadCount = 1000;

        CountDownLatch countDownLatch = new CountDownLatch(ThreadCount);


        for (int i = 0; i < ThreadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        inc();
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("等待自线程结束");
        countDownLatch.await();

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + count);
    }


}
