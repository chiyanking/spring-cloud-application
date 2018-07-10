package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {


    @Test
    public void testCacheThreadPool() throws InterruptedException {

        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            Object taskName = null;
            executorService.execute(new untitledTask("线程" + i));
        }
        synchronized (pool) {
            pool.wait();
        }

    }

    @Test
    public void testFixThreadPool() throws InterruptedException {


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100000000; i++) {
            fixedThreadPool.execute(new untitledTask("线程" + i));
        }
        synchronized (fixedThreadPool) {
            fixedThreadPool.wait();
        }

        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
    }


    class untitledTask implements Runnable {

        private String taskName;

        private BlockingQueue queue;

        public untitledTask(String taskName) {
            this.taskName = taskName;
        }

        public untitledTask(BlockingQueue<Runnable> linkedBlockingQueue, String taskName) {
            this(taskName);
            queue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                System.out.println(String.format("%s 线程运行第 %s 次！阻塞线程：%s 个", taskName, j, queue.size()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
