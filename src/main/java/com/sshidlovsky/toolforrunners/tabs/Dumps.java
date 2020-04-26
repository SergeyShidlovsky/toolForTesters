package com.sshidlovsky.toolforrunners.tabs;

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

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\DoNotAttachGetLastCUEDump.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetLastCUEDumpZIP.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button3
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetManualCUEDumpZIP.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button4
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetMemoryDump.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button4
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button5) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\OpenDumpFolder.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Buttons press emulation by pressing Num1 button
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
