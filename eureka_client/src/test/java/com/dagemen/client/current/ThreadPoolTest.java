package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {

    @Test
    public void testPool() throws InterruptedException {


        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000l, TimeUnit.SECONDS, runnables, Executors.defaultThreadFactory(), (r, executor) -> {
            BlockingQueue<Runnable> queue = executor.getQueue();
            System.out.println("executor.getQueue() == runnables " + String.valueOf(queue == runnables));
            System.out.println(r);
        });


        for (int i = 0; i < 10000; i++) {
            Thread.sleep(100);
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    ArrayBlockingQueue<Runnable> runnables1 = runnables;
                    System.out.println(runnables1.size());
                    System.out.println(Thread.currentThread().getName() + "  running");
                    try {
                        Thread.sleep(10000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
