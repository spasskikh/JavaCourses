package com.task08.task08_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Matcher implements Runnable {

    private File dir;
    private char symbol;
    private Map<String, Integer> result;

    public Matcher(File dir, char symbol, Map<String, Integer> result) {
        this.dir = dir;
        this.symbol = symbol;
        this.result = result;
    }

    public int search(File file) {
        int counter = 0;
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] split = str.split("\\W");
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
            if (ff.isDirectory()) {
                System.out.println(ff.getName());
                new Thread(new Matcher(ff, symbol, result)).start();
            } else {
                wordsCounter = search(ff);
                System.out.println(ff.getName());
                if (wordsCounter != 0) {
                    result.put(ff.getName(), wordsCounter);
                }
            }
        }
    }
}

