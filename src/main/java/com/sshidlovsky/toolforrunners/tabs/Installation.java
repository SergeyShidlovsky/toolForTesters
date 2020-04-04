package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Installation extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Installation(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        final JButton button1 = new JButton("GetInstallLog [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Copy setuoapi.dev.log to Desktop");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("GetOEMFiles [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Copy  OEM files to Desktop");
        button2.setSize(313, 110);
        add(button2);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Installation\\GetInstallLog.bat");
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
                //Button1 will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Installation\\GetOEMFiles.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
        KeyListener listener4 = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1:
                        button1.doClick();
                        break;

                    case KeyEvent.VK_2:
                        button2.doClick();
                        break;
                }
            }
        };

        button1.addKeyListener(listener4);
        add(statusLabel[4]);
        this.addKeyListener(listener4);
    }
}
