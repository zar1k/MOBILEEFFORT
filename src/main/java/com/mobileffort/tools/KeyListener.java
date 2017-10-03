package com.mobileffort.tools;

import com.mobileffort.logic.AppLogic;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

/**
 * This class listens for keyboard events.
 */
public class KeyListener implements Runnable {

    @Override
    public void run() {
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                // To abort the counting of files.
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                    AppLogic.setInterrupt(true);
                }
                // Quit the program.
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_Q) {
                    keyboardHook.shutdownHook();
                }
            }
        });
    }
}