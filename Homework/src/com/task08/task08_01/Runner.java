package com.task08.task08_01;

public class Runner {

    public void run() {

        new Thread(()-> {
            for (int i = 10; i > 0 ; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb!!!");
        }).start();
    }
}
