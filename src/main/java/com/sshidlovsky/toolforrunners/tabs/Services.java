package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksServices;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Services extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
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

    public Services(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("Open Services [1]");
        button2 = new JButton("Start Audio Service [2]");
        button3 = new JButton("Start Integration Service [3]");
        button4 = new JButton("Stop Audio Service [4]");
        button5 = new JButton("Stop Integration Service [5]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Open Services window", font);
        addButtonWithPreferencesToTab(button2,"Start Audio Service", font);
        addButtonWithPreferencesToTab(button3,"Start Integration Service", font);
        addButtonWithPreferencesToTab(button4,"Stop Audio Service", font);
        addButtonWithPreferencesToTab(button5,"Stop Integration Service", font);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksServices.OPEN_SERVICE.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksServices.START_AUDIO_SERVICE.getValue(), timer, tm, 3);
        addActionListenerToButton(button3, LinksServices.START_INTEGRATION_SERVICE.getValue(), timer, tm, 4);
        addActionListenerToButton(button4, LinksServices.STOP_AUDIO_SERVICE.getValue(), timer, tm, 3);
        addActionListenerToButton(button5, LinksServices.STOP_INTEGRATION_SERVICE.getValue(), timer, tm, 5);

        //Add KeyListener to tab
        KeyListener listener8 = new KeyAdapter() {
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
        button1.addKeyListener(listener8);
        button2.addKeyListener(listener8);
        button3.addKeyListener(listener8);
        button4.addKeyListener(listener8);
        button5.addKeyListener(listener8);
        add(statusLabel[8]);
        this.addKeyListener(listener8);
    }
}