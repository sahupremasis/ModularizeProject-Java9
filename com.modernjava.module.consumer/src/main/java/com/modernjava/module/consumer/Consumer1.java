package com.modernjava.module.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Consumer1 {

    private ArrayBlockingQueue<Integer> arrayBlockingQueue;
    public Consumer1(ArrayBlockingQueue<Integer> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;

        Runnable consmuer = () -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    Integer poll;
                    poll = arrayBlockingQueue.take();
                    System.out.println("Polled:" + poll);
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(consmuer);
    }

}
