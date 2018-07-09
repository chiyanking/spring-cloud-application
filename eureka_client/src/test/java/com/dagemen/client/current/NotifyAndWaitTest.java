package com.dagemen.client.current;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体使用notify和wait方法
 * 从字节码层面来看 monitorenter monitorexit 两个代码区域
 * 为了看下获取线程的monitorenter实验类
 */
public class NotifyAndWaitTest {


    Logger logger = LoggerFactory.getLogger(NotifyAndWaitTest.class);

    @Test
    public void testMonitor() throws InterruptedException {

        Object lock = new Object();
        new Thread(() -> {
            try {
                logger.info("{}:线程开始运行", Thread.currentThread().getName());
                synchronized (lock) {
                    lock.wait();
                }
                logger.info("{}:线程等待 时间:{}", Thread.currentThread().getName(), System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(100l);
                logger.info("{}:线程开始运行", Thread.currentThread().getName());
                synchronized (lock) {
                    lock.notifyAll();
                    logger.info("{}:唤醒一个线程 时间:{}", Thread.currentThread().getName(), System.currentTimeMillis());
                }
                Thread.sleep(5*100000l);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100000l);
    }
}
