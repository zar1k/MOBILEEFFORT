package com.mobileffort.tools;

import com.mobileffort.output.Display;
import com.mobileffort.output.IDisplay;
import com.mobileffort.output.IOutputFile;
import com.mobileffort.output.OutputFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * This class contains a method to count files in a directory and subdirectory.
 */
public class CounterFiles extends SimpleFileVisitor<Path> implements Runnable {
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
        try {
            Files.walkFileTree(Paths.get(path), this);
        } catch (IOException e) {
            System.out.println("If an I/O error is thrown by a visitor method.");
        }
        outputFile.save(this);
        display.show(this);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        numberFilesFound++;
        return FileVisitResult.CONTINUE;
    }
}
