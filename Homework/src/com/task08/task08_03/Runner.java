package com.task08.task08_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

    private Map<Integer, Integer> hashMap = new HashMap<>();
    private Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    private final int COUNT = 1000;

    public void run() {

        System.out.println("Working with HashMap" + workHashMap());
        System.out.println("Working with ConcurrentHashMap" + workConcurrentHashMap());
    }

    private String workHashMap() {
        Thread[] writeThreads = new Thread[COUNT];
        Thread[] readThreads = new Thread[COUNT];

        for (int i = 0; i < COUNT; i++) {
            int j = i;
            writeThreads[i] = new Thread(() -> {
                synchronized (hashMap) {
                    hashMap.put(j, j);
                }
            });
            readThreads[i] = new Thread(() -> {
                synchronized (hashMap) {
                    hashMap.get(j);
                }
            });
        }

        long start = System.nanoTime();
        startThreads(writeThreads, readThreads);
        long end = System.nanoTime();

        return String.format("\n%.4f", (end - start) / 1_000_000_000.0);
    }

    private String workConcurrentHashMap() {
        Thread[] writeThreads = new Thread[COUNT];
        Thread[] readThreads = new Thread[COUNT];

        for (int i = 0; i < COUNT; i++) {
            int j = i;
            writeThreads[i] = new Thread(() -> {
                concurrentHashMap.put(j, j);
            });
            readThreads[i] = new Thread(() -> {
                concurrentHashMap.get(j);
            });
        }

        long start = System.nanoTime();
        startThreads(writeThreads, readThreads);
        long end = System.nanoTime();

        return String.format("\n%.4f", (end - start) / 1_000_000_000.0);
    }

    private void startThreads(Thread[] writeThreads, Thread[] readThreads) {
        for (int i = 0; i < COUNT; i++) {
            writeThreads[i].start();
            readThreads[i].start();
        }
        for (int i = 0; i < COUNT; i++) {
            try {
                writeThreads[i].join();
                readThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
