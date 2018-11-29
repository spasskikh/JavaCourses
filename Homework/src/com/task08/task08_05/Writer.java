package com.task08.task08_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class Writer implements Runnable {

    private SynchronousQueue<String> result;
    private String fileName;

    public Writer(SynchronousQueue<String> result, String fileName) {
        this.result = result;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))) {
            String str;
            while (!("DONE".equals(str = result.take()))) {
                bw.write(str + '\n');
                bw.flush();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
