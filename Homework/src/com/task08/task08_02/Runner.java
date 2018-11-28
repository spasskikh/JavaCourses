package com.task08.task08_02;

public class Runner {

    private Integer value = 0;
    private boolean flag = true;

    public void run() {

        new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 100; i++) {
                    while (!flag) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    value++;
                    flag = false;
                    notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 100; i++) {
                    while (flag) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(value);
                    flag = true;
                    notify();
                }
            }
        }).start();
    }
}
