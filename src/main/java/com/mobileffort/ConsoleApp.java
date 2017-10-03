package com.mobileffort;

import com.mobileffort.logic.AppLogic;
import com.mobileffort.tools.KeyListener;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        System.out.println("*******  CONSOLE APPLICATION - FILE COUNTER *******");
        System.out.println("Press <Esc> to stop the counting of files.");
        System.out.println("Press <Q> to quit the program.");

        Scanner reader = new Scanner(System.in);
        System.out.print("consoleapp ");

        String first = reader.next();
        String second = reader.next();

        AppLogic logic = new AppLogic(first, second);
        logic.parallelComputing();

        Thread thread = new Thread(new KeyListener());
        thread.start();
    }
}
