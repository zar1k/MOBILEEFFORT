package com.mobileffort.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains a method for parsing files.
 */
public class Parser {
    /**
     * Parses a data file.
     *
     * @param fileName The name of the file which contains the folder to count files.
     * @return A list of paths in the string representation.
     */
    public List<String> parseInputFile(String fileName) {
        List<String> paths = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            paths = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Having problems reading from a file.");
        }
        return paths;
    }
}