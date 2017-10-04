package com.mobileffort;

import com.mobileffort.logic.AppLogic;
import com.mobileffort.tools.KeyListener;
import com.mobileffort.exception.LogicException;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        System.out.println("*******  CONSOLE APPLICATION - FILE COUNTER *******");
        System.out.println("Press <Esc> to stop the counting of files.");
        System.out.println("Press <Q> to quit the program.");

        Scanner reader = new Scanner(System.in);
        System.out.print("consoleapp ");
        AppLogic logic = null;

        for (; ; ) {
            String first = reader.next();
            String second = reader.next();
            try {
                logic = new AppLogic(first, second);
                break;
            } catch (LogicException e) {
                System.out.println("The file doesn't exist. Please enter again.");
                System.out.print("consoleapp ");
            }
        }
        logic.parallelComputing();

        Thread thread = new Thread(new KeyListener());
        thread.start();
    }
}
