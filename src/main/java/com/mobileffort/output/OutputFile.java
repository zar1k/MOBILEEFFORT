package com.mobileffort.output;

import com.mobileffort.logic.AppLogic;
import com.mobileffort.tools.CounterFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class contains a method for saving data to a file.
 */
public class OutputFile implements IOutputFile {
    @Override
    /**
     * The method saves the data to a file in format (Path;Number of files in a folder).
     */
    public void save(CounterFiles counterFiles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AppLogic.getOutputFile(), true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(counterFiles.getPath()).append(";").append(counterFiles.getNumberFilesFound()).append("\n");
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}