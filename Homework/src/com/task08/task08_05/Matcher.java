package com.task08.task08_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Matcher implements Runnable {

    private File dir;
    private char symbol;
    private SynchronousQueue<String> result;

    public Matcher(File dir, char symbol, SynchronousQueue<String> result) {
        this.dir = dir;
        this.symbol = symbol;
        this.result = result;
    }

    public int search(File file) {
        int counter = 0;
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] split = str.split("\\b");
                for (String s : split) {
                    if (!s.isEmpty() && s.toCharArray()[0] == symbol) {
                        counter++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    @Override
    public void run() {
        int wordsCounter;

        File[] files = dir.listFiles();

        for (File ff : files) {
            try {
                if (ff.isDirectory()) {
                    Thread thread = new Thread(new Matcher(ff, symbol, result));
                    thread.start();
                    thread.join();
                } else if ((wordsCounter = search(ff)) > 0) {
                    result.put(ff.getName() + " - " + wordsCounter);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

