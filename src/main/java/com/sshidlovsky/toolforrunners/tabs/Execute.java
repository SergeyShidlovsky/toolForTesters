package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksExecute;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Execute extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;
    final JButton button6;
    final JButton button7;
    final JButton button8;
    private JLabel tabStatusLabel;
    private KeyListener listener3;
    private Map<Integer, JButton> buttonAssignment;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    private void addButtonWithPreferencesToTab(final JButton button, String tooltip, Font font, int keyCode) {
        button.setFont(font);
        button.setVisible(true);
        button.setToolTipText(tooltip);
        button.setSize(313, 110);
        add(button);
        buttonAssignment.put(keyCode, button);
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

    private KeyListener addKeyListenerToTab() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Integer currentAssignmentCode;
                for (int i = 0; i < buttonAssignment.values().size(); i++) {
                    currentAssignmentCode = (Integer) buttonAssignment.keySet().toArray()[i];
                    if (e.getKeyCode() == currentAssignmentCode) {
                        buttonAssignment.get(currentAssignmentCode).doClick();
                    }
                }
            }
        };
    }

    public Execute(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton(" Application wizard [1] ");
        button2 = new JButton(" Audio Settings [2] ");
        button3 = new JButton(" Device Manager [3] ");
        button4 = new JButton(" Device and Printers [4] ");
        button5 = new JButton(" Device Metadata [5] ");
        button6 = new JButton(" Remote Desktop [6] ");
        button7 = new JButton(" Task Manager [7] ");
        button8 = new JButton(" Update Server [8] ");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Open Application wizard", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Open Audio Settings", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Open Device Manager", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Open Device and Printers", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5, "Open Device Metadata", font, KeyEvent.VK_5);
        addButtonWithPreferencesToTab(button6, "Open RDP Connections", font, KeyEvent.VK_6);
        addButtonWithPreferencesToTab(button7, "Open Device Manager", font, KeyEvent.VK_7);
        addButtonWithPreferencesToTab(button8, "Open Update server", font, KeyEvent.VK_8);

        //Add ActionListener to all buttons
        addActionListenerToButton(button1, LinksExecute.OPEN_APPLICATION_WIZARD.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksExecute.OPEN_AUDIO_SETTINGS.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_DEVICE_MANAGER.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_DEVICE_AND_PRINTERS.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_DEVICE_METADATA.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_DPR_CONNECTION.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_TASK_MANAGER.getValue(), timer, tm, 2);
        addActionListenerToButton(button1, LinksExecute.OPEN_UPDATE_SERVICE.getValue(), timer, tm, 2);

        //Create tab-specific KeyListener
        listener3 = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener3);
        button2.addKeyListener(listener3);
        button3.addKeyListener(listener3);
        button4.addKeyListener(listener3);
        button5.addKeyListener(listener3);
        button6.addKeyListener(listener3);
        button7.addKeyListener(listener3);
        button8.addKeyListener(listener3);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[3];
        add(tabStatusLabel);
    }
}
