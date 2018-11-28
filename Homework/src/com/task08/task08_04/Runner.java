package com.task08.task08_04;

import java.util.concurrent.ForkJoinPool;

public class Runner {

    private long n = 1_000_000L;
    private int poolSize = 8;

    public void run() {
        System.out.printf("Sum for range 1 ... %d:\n%d", n, calc());
    }

    private long calc() {
        ForkJoinPool pool = new ForkJoinPool(poolSize);
        return pool.invoke(new RecursiveSum(0, n));
    }


}
