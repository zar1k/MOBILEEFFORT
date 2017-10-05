package com.mobileffort.output;

import com.mobileffort.logic.AppLogic;
import com.mobileffort.tools.CounterFiles;

import java.util.Formatter;

/**
 * This class contains a method to output a search result on the screen.
 */
public class Display implements IDisplay {
    static {
        Formatter fmt = new Formatter();
        System.out.println("---------------------------------------------------");
        fmt.format("%-10s| %-10s| %-30s ", "Serial number", "Number of files", "Source path");
        System.out.println(fmt);
        System.out.println("---------------------------------------------------");
        fmt.close();
    }

    @Override
    /**
     * Method of displaying search result on screen.
     */
    public void show(CounterFiles counter) {
        Formatter fmt = new Formatter();
        if (AppLogic.isInterrupt() == false) {
            fmt.format("%-13d| %-15d| %-22s", counter.getSequentialNumber(), counter.getNumberFilesFound(), counter.getPath());
            System.out.println(fmt);
        } else {
            fmt.format("%-13d| %-15d| %-22s %-10s", counter.getSequentialNumber(), counter.getNumberFilesFound(), counter.getPath(), "Search stopped by user");
            System.out.println(fmt);
        }
        fmt.close();
    }
}