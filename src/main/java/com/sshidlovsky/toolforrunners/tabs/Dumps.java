package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksDumps;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dumps extends JPanel {

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

    public Dumps(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        final JButton button1 = new JButton("Do Not Attach Last CUE Dump [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("Get Last CUE Dump ZIP [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton("Get Manual CUE Dump ZIP [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setSize(313, 110);
        add(button3);

        final JButton button4 = new JButton("Get Memory Dump [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setSize(313, 110);
        add(button4);

        final JButton button5 = new JButton("Open Dump Folder [5]");
        button5.setFont(font);
        button5.setVisible(true);
        button5.setSize(313, 110);
        add(button5);

        //Add ActionListeners to all Buttons
        addActionListenerToButton(button1, LinksDumps.DO_NOT_ATTACH_GET_LAST_CUE_DUMP.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksDumps.GET_LAST_CUE_DUMP_ZIP.getValue(), timer, tm, 2);
        addActionListenerToButton(button3, LinksDumps.GET_MANUAL_CUE_DUMP_ZIP.getValue(), timer, tm, 2);
        addActionListenerToButton(button4, LinksDumps.GET_MEMORY_DUMP.getValue(), timer, tm, 2);
        addActionListenerToButton(button5, LinksDumps.OPEN_DUMP_FOLDER.getValue(), timer, tm, 2);

        //Add KeyListener for Buttons press emulation
        KeyListener listener2 = new KeyAdapter() {
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

        //Add key Listeners to All buttons
        button1.addKeyListener(listener2);
        button2.addKeyListener(listener2);
        button3.addKeyListener(listener2);
        button4.addKeyListener(listener2);
        button5.addKeyListener(listener2);
        add(statusLabel[2]);
        this.addKeyListener(listener2);
    }
}