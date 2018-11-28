package com.task08.task08_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterResult implements Runnable {

    private Map<String, Integer> result;
    private String fileName;

    public FileWriterResult(Map<String, Integer> result, String fileName) {
        this.result = result;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(new File(fileName)))) {
            while (!(result.containsKey("DONE"))) {
                for (String key : result.keySet()) {
                    bw.write(key);
                    bw.write(" contains ");
                    bw.write(Integer.toString(result.remove(key)));
                    bw.write(" words.\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
