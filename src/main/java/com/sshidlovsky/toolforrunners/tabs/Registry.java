package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registry extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Registry(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        final JButton button1 = new JButton("OpenRegistryEditor [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Opens Registry Editor");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("OpenRegistryEditorClinkPIDs [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Open Registry Editor Clink PIDs");
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton("OpenRegistryEditorErrorReporting [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Open Registry Editor Error Reporting");
        button3.setSize(313, 110);
        add(button3);
        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Registry\\OpenRegistryEditor.bat");
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
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Registry\\OpenRegistryEditorClinkPIDs.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button2
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Registry\\OpenRegistryEditorErrorReporting.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
        KeyListener listener7 = new KeyAdapter() {
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
                }
            }
        };

        button1.addKeyListener(listener7);
        button2.addKeyListener(listener7);
        button3.addKeyListener(listener7);
        add(statusLabel[7]);
        this.addKeyListener(listener7);
    }
}
