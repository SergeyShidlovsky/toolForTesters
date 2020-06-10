package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksApplication;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    private JLabel tabStatusLabel;
    private KeyListener listener;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Application(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Configure visual settings of Button1
        button1 = new JButton("Restart With Cleared Appdata Programdata Restrt Service [1]");
        button1.setFont(font);
        button1.setSize(313, 110);
        add(button1);

        //Configure visual setting of Button2
        button2 = new JButton("Restart With Cleared Appdata Programdata Restart Service With BackUp [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("");
        button2.setSize(313, 110);
        add(button2);

        //Configure visual settings of Button3
        button3 = new JButton("Restart With Debug Logging And Cleared Appdata Programdata Restrt Service [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("");
        button3.setSize(313, 110);
        add(button3);

        //Configure visual setting of Button4
        button4 = new JButton("Restart With Debug Logging And Cleared Appdata Programdata Restart Service With BackUp [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("");
        button4.setSize(313, 110);
        add(button4);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec(LinksApplication
                                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE.getValue());
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
                // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
            }
        });

        //Add ActionListeners of Button2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec(LinksApplication
                                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                                .getValue());
                        timeReset(3, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button3
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button3 will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec(LinksApplication
                                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE
                                .getValue());
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button4
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button4 will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec(LinksApplication
                                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                                .getValue());
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener to tab
        listener = new KeyAdapter() {
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

        button1.addKeyListener(listener);
        button2.addKeyListener(listener);
        button3.addKeyListener(listener);
        button4.addKeyListener(listener);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[1];
        add(tabStatusLabel);
    }
}
