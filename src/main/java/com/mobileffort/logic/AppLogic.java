package com.mobileffort.logic;

import com.mobileffort.tools.CounterFiles;
import com.mobileffort.tools.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the application logic.
 */
public class AppLogic {
    private static boolean interrupt = false;
    private static String outputFile;

    private Parser parser;
    private String path;
    private List<Thread> threads;


    public AppLogic(final String path, final String outputFile) {
        AppLogic.outputFile = outputFile;
        this.path = path;
        this.parser = new Parser();
        this.threads = new ArrayList<>();
    }

    public static String getOutputFile() {
        return outputFile;
    }

    public static boolean isInterrupt() {
        return interrupt;
    }

    public static void setInterrupt(boolean interrupt) {
        AppLogic.interrupt = interrupt;
    }

    /**
     * The method creates and starts threads for each directory in which you want to count the files.
     */
    public void parallelComputing() {
        int sequentialNumber = 0;
        if (parser.parseInputFile(this.path).isEmpty()) {
            System.out.println("The file is empty.");
            return;
        }
        for (String currentPath : parser.parseInputFile(this.path)) {
            sequentialNumber++;
            threads.add(new Thread(new CounterFiles(sequentialNumber, currentPath)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
