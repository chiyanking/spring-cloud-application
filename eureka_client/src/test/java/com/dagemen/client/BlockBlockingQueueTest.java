package com.dagemen.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockBlockingQueueTest {

    private static Logger logger = LoggerFactory.getLogger(BlockBlockingQueueTest.class);

    /**
     * 定义装苹果的篮子
     */
    public static class Basket {

        private String apple = "An apple";
        // 篮子，能够容纳3个苹果
        BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

        // 生产苹果，放入篮子
        public void produce() throws InterruptedException {
            // put方法放入一个苹果，若basket满了，等到basket有位置
            basket.put(apple);
        }

        // 消费苹果，从篮子中取走
        public String consume() throws InterruptedException {
            // take方法取出一个苹果，若basket为空，等到basket有苹果为止(获取并移除此队列的头部)
            return basket.take();
        }
    }

    // 定义苹果生产者
    static class Producer implements Runnable {
        private Basket basket;

        public Producer(Basket basket) {
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    String instance = Thread.currentThread().getName();
                    logger.info("{} 生产苹果", instance);
                    basket.produce();
                    logger.info("{} 完毕", instance);
                    // 休眠300ms
                    Thread.sleep(300);
                }
            } catch (InterruptedException ex) {
                logger.info("Producer Interrupted");
            }
        }
    }

    // 定义苹果消费者
    static class Consumer implements Runnable {
        private Basket basket;

        public Consumer(Basket basket) {
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    // 消费苹果
                    String instance = Thread.currentThread().getName();
                    logger.info("{} 开始消费", instance);
                    basket.consume();
                    logger.info("{} 消费完毕", instance);
                    // 休眠1000ms
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                System.out.println("Consumer Interrupted");
            }
        }
    }

    public static void main(String[] args) {

        // 建立一个装苹果的篮子
        Basket basket = new Basket();


        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer(basket);
        Producer producer2 = new Producer(basket);
        Consumer consumer = new Consumer(basket);
        Consumer consumer2 = new Consumer(basket);
        service.submit(producer);
        service.submit(producer2);
        service.submit(consumer);
        service.submit(consumer2);
        // 程序运行5s后，所有任务停止
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        service.shutdownNow();
    }
}
