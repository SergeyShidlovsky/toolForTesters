package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksInstallation;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Installation extends JPanel {

    private JButton button1;
    private JButton button2;
    private JLabel tabStatusLabel;
    private KeyListener listener4;

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

    public Installation(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("GetInstallLog [1]");
        button2 = new JButton("GetOEMFiles [2]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Copy setuoapi.dev.log to Desktop", font);
        addButtonWithPreferencesToTab(button2, "Copy OEM files to Desktop", font);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksInstallation.GET_OEM_FILES.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksInstallation.GET_INSTALL_LOG.getValue(), timer, tm, 2);

        //Add KeyListener for Buttons' press emulation
        listener4 = new KeyAdapter() {
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

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener4);
        button2.addKeyListener(listener4);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[4];
        add(tabStatusLabel);
    }
}
