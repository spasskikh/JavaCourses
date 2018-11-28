package com.task08.task08_04;

import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Long> {

    private long N = 20L;

    private long from;
    private long to;

    public RecursiveSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if ((to - from) < N) {
            long localSum = 0L;
            for (long i = from; i <= to; i++) {
                localSum += i;
            }
            return localSum;
        } else {
            long mid = (from + to) / 2;

            RecursiveSum firstHalf = new RecursiveSum(from, mid);
            firstHalf.fork();

            RecursiveSum secondHalf = new RecursiveSum(mid + 1, to);
            long resultSecond = secondHalf.compute();

            return firstHalf.join() + resultSecond;
        }
    }
}
