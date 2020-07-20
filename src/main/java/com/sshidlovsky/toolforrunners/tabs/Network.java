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

    public Network(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        button1 = new JButton("DisableNetworkAdapter [1]");
        button2 = new JButton("EnableNetworkAdapter [2]");
        button3 = new JButton("OpenNetworkAdapter [3]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Disables active network adapter", font);
        addButtonWithPreferencesToTab(button2,"Enables active network adapter", font);
        addButtonWithPreferencesToTab(button3,"Opens network adapter settings", font);

        //Add ActionListeners to all buttons
        addActionListenerToButton(button1, LinksNetwork.DISABLE_NETWORK_ADAPTER.getValue(), timer, tm, 10);
        addActionListenerToButton(button2, LinksNetwork.ENABLE_NETWORK_ADAPTER.getValue(), timer, tm, 10);
        addActionListenerToButton(button3, LinksNetwork.OPEN_NETWORK_ADAPTER.getValue(), timer, tm, 2);

        //Add KeyListener for all Buttons' press emulation
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