package com.hust.kstn.garbage;

import java.io.IOException;
import java.nio.file.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String fileName = "./test.dmbk";
        long startTime, endTime;

        byte[] inputBytes = Files.readAllBytes(Paths.get(fileName));
        startTime = System.currentTimeMillis();
        StringBuilder outputBuilder = new StringBuilder(inputBytes.length);
        for (byte b : inputBytes) {
            outputBuilder.append((char) b);
        }
        String outputString = outputBuilder.toString();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}