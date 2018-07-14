package com.dagemen.client.current;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class TestCountDown {


    @Test
    public void countDown() {


        CountDownLatch countDownLatch = new CountDownLatch(11);


        countDownLatch.countDown();
    }
}
