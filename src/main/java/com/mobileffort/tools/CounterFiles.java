package com.mobileffort.tools;

import com.mobileffort.logic.AppLogic;
import com.mobileffort.output.Display;
import com.mobileffort.output.IDisplay;
import com.mobileffort.output.IOutputFile;
import com.mobileffort.output.OutputFile;

import java.io.File;

/**
 * This class contains a method to count files in a directory and subdirectory.
 */
public class CounterFiles implements Runnable {
    private IDisplay display = new Display();
    private IOutputFile outputFile = new OutputFile();
    // Sequential record number.
    private int sequentialNumber;
    // The number of files found
    private int numberFilesFound;
    // Source path to search
    private String path;

    public CounterFiles(final int sequentialNumber, final String path) {
        this.sequentialNumber = sequentialNumber;
        this.path = path;
    }

    public int getSequentialNumber() {
        return sequentialNumber;
    }

    public int getNumberFilesFound() {
        return numberFilesFound;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void run() {
        counterFiles(path);
        display.show(this);
        outputFile.save(this);
    }

    /**
     * Counts the files of the directory and its subdirectories.
     *
     * @param path The path to the directory in which you want to search.
     * @return Number of files found when crawling the directory and nested subdirectories of directories.
     */
    private int counterFiles(final String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File currentFile : files) {
            if (AppLogic.isInterrupt() == true) {
                break;
            }
            if (currentFile.isDirectory()) {
                counterFiles(currentFile.getPath());
            }
            if (currentFile.isFile()) {
                numberFilesFound++;
            }
        }
        return numberFilesFound;
    }
}
