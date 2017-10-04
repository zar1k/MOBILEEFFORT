package com.mobileffort.logic;

import com.mobileffort.exception.LogicException;
import com.mobileffort.tools.CounterFiles;
import com.mobileffort.tools.Parser;

import java.nio.file.Files;
import java.nio.file.Paths;
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


    public AppLogic(final String path, final String outputFile) throws LogicException {
        verifyFile(path);
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
     * @param file
     * @return
     * @throws LogicException
     */
    private boolean verifyFile(String file) throws LogicException {
        if (Files.exists(Paths.get(file))) {
            return true;
        }
        throw new LogicException("The specified file does not exist.");
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
            try {
                verifyFile(currentPath);
            } catch (LogicException e) {
                System.out.println("");
            }
            threads.add(new Thread(new CounterFiles(sequentialNumber, currentPath)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
