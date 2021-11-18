package com.modernjava.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Producer {
    private ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public Producer(ArrayBlockingQueue<Integer> arrayBlockingQueue)  {

        this.arrayBlockingQueue = arrayBlockingQueue;
        Runnable producer = () -> {
            int i = 0;
            while (true) {
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Added: " + i);
                    TimeUnit.MICROSECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);

    }

}
