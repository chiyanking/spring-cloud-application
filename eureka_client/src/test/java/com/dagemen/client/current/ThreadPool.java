package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {


    @Test
    public void testCacheThreadPool() throws InterruptedException {

        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            Object taskName = null;
            executorService.execute(new Runnable() {
                private String taskName;
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " 次数");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        synchronized (pool) {
            pool.wait();
        }

    }
}
