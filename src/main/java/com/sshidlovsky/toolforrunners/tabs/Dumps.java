package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksDumps;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dumps extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;
    private JLabel tabStatusLabel;
    private KeyListener listener2;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    private void addActionListenerToButton(final JButton button, final String command, final Timer timer,
                                           final TimerTick tm, final int delay) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button) {
                    try {
                        Runtime.getRuntime().exec(command);
                        timeReset(delay, timer, tm);
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });
    }

    private void addButtonWithPreferencesToTab(final JButton button, String tooltip, Font font) {
        button.setFont(font);
        button.setVisible(true);
        button.setToolTipText(tooltip);
        button.setSize(313, 110);
        add(button);
    }

    public Dumps(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("Do Not Attach Last CUE Dump [1] ");
        button2 = new JButton("Get Last CUE Dump ZIP [2] ");
        button3 = new JButton("Get Manual CUE Dump ZIP [3] ");
        button4 = new JButton("Get Memory Dump [4] ");
        button5 = new JButton("Open Dump Folder [5] ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Do Not Attach Last CUE Dump", font);
        addButtonWithPreferencesToTab(button2, "Get Last CUE Dump ZIP", font);
        addButtonWithPreferencesToTab(button3, "Get Manual CUE Dump ZIP", font);
        addButtonWithPreferencesToTab(button4, "Get Memory Dump", font);
        addButtonWithPreferencesToTab(button5, "Open Dump Folder", font);

        //Add ActionListeners to all Buttons
        addActionListenerToButton(button1, LinksDumps.DO_NOT_ATTACH_GET_LAST_CUE_DUMP.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksDumps.GET_LAST_CUE_DUMP_ZIP.getValue(), timer, tm, 2);
        addActionListenerToButton(button3, LinksDumps.GET_MANUAL_CUE_DUMP_ZIP.getValue(), timer, tm, 2);
        addActionListenerToButton(button4, LinksDumps.GET_MEMORY_DUMP.getValue(), timer, tm, 2);
        addActionListenerToButton(button5, LinksDumps.OPEN_DUMP_FOLDER.getValue(), timer, tm, 2);

        //Add KeyListener for Buttons press emulation
        listener2 = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1:
                        button1.doClick();
                        break;
                    case KeyEvent.VK_2:
                        button2.doClick();
                        break;
                    case KeyEvent.VK_3:
                        button3.doClick();
                        break;
                    case KeyEvent.VK_4:
                        button4.doClick();
                        break;
                    case KeyEvent.VK_5:
                        button5.doClick();
                        break;
                }
            }
        };

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener2);
        button2.addKeyListener(listener2);
        button3.addKeyListener(listener2);
        button4.addKeyListener(listener2);
        button5.addKeyListener(listener2);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[2];
        add(tabStatusLabel);
    }
}