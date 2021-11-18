package com.modernjava.module.client;

import com.modernjava.module.consumer.Consumer1;
import com.modernjava.producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;

public class MainClient {

    public static void main(String [] args) {
        System.out.println("Starting MainClient");
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(100);
        Producer produer = new Producer(arrayBlockingQueue);
        Consumer1 consumer = new Consumer1(arrayBlockingQueue);
    }

}
