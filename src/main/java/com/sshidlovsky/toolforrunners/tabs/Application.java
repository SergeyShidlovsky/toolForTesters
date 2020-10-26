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

    public Application(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("Restart With Cleared AppData ProgramData Restrt Service [1]");
        button2 = new JButton("Restart With Cleared AppData ProgramData Restart Service With BackUp [2]");
        button3 = new JButton("Restart With Debug Logging And Cleared AppData ProgramData Restrt Service [3]");
        button4 = new JButton("Restart With Debug Logging And Cleared AppData ProgramData Restart Service With " +
                "BackUp [4]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Restart With Cleared AppData ProgramData Restart Service",
                font);
        addButtonWithPreferencesToTab(button2, "Restart With Cleared AppData ProgramData Restart Service " +
                "With BackUp", font);
        addButtonWithPreferencesToTab(button3, "Restart With Debug Logging And Cleared AppData ProgramData " +
                "Restrt Service", font);
        addButtonWithPreferencesToTab(button4, "Restart With Debug Logging And Cleared AppData ProgramData " +
                "Restart Service With BackUp", font);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksApplication
                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE
                .getValue(), timer, tm, 1);
        addActionListenerToButton(button2, LinksApplication
                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                .getValue(), timer, tm, 1);
        addActionListenerToButton(button3, LinksApplication
                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE
                .getValue(), timer, tm, 1);
        addActionListenerToButton(button4, LinksApplication
                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                .getValue(), timer, tm, 1);

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

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener);
        button2.addKeyListener(listener);
        button3.addKeyListener(listener);
        button4.addKeyListener(listener);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[1];
        add(tabStatusLabel);
    }
}
