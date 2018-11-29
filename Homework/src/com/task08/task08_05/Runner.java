package com.task08.task08_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Runner {

    private static final String RESULT_SET = "/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/files/result.txt";

    public void run() throws InterruptedException {

        SynchronousQueue<String> result = new SynchronousQueue<>();

        String dir = getParam("Enter directory:");
        char symbol = getParam("Enter symbol:").toCharArray()[0];

        Writer writer = new Writer(result, RESULT_SET);
        Thread fileWriterThread = new Thread(writer);
        fileWriterThread.start();

        Matcher counter = new Matcher(new File(dir), symbol, result);
        Thread fileScannerThread = new Thread(counter);
        fileScannerThread.start();
        fileScannerThread.join();

        result.put("DONE");
        fileWriterThread.join();

        printResults(RESULT_SET);
    }

    private void printResults(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getParam(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
}
