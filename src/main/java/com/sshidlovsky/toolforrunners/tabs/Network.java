package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksNetwork;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Network extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    private JLabel tabStatusLabel;
    private KeyListener listener6;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Network(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        button1 = new JButton("DisableNetworkAdapter [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Disables active network adapter");
        button1.setSize(313, 110);
        add(button1);

        button2 = new JButton("EnableNetworkAdapter [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Enables active network adapter");
        button2.setSize(313, 110);
        add(button2);

        button3 = new JButton("OpenNetworkAdapter [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Opens network adapter settings");
        button3.setSize(313, 110);
        add(button3);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec(LinksNetwork.DISABLE_NETWORK_ADAPTER.getValue());
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
                        Runtime.getRuntime().exec(LinksNetwork.ENABLE_NETWORK_ADAPTER.getValue());
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
                        Runtime.getRuntime().exec(LinksNetwork.OPEN_NETWORK_ADAPTER.getValue());
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
        listener6 = new KeyAdapter() {
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

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener6);
        button2.addKeyListener(listener6);
        button3.addKeyListener(listener6);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[6];
        add(tabStatusLabel);
    }
}