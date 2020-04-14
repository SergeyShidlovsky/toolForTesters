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

        final JButton button1 = new JButton("GelLastAutoDump [1]");

        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Select last autodump Copy to desktop Compress to *.zip Create %Username%* on FTP Copy *.zip to FTP Open Username folder");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("GetLastManualDump [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Select last MANUALLY CREATED Dump and Copy to desktop Compress to *.zip Create %Username%* on FTP Copy *.zip to FTP Open Username folder");
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton("GetLastMemoryDump [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Copy to desktop and FTP MEMORY Dump after BSOD or other issues");
        button3.setSize(313, 110);
        add(button3);

        final JButton button4 = new JButton("OpenTaskManager [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("Open SysWOW64 task manager for Manual Dump creation");
        button4.setSize(313, 110);
        add(button4);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetLastCUEDumpZIP.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetManualCUEDumpZIP.bat");
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
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\OpenTaskManager.bat");
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
                }
            }
        };

        button1.addKeyListener(listener2);
        add(statusLabel[2]);
        this.addKeyListener(listener2);
    }
}
