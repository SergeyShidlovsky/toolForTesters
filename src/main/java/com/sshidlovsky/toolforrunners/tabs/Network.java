package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksNetwork;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Network extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    private JLabel tabStatusLabel;
    private KeyListener listener6;
    private Map<Integer, JButton> buttonAssignment;

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

    private void addButtonWithPreferencesToTab(final JButton button, String tooltip, Font font, int keyCode) {
        button.setFont(font);
        button.setVisible(true);
        button.setToolTipText(tooltip);
        button.setSize(313, 110);
        add(button);
        buttonAssignment.put(keyCode, button);
    }

    private KeyListener addKeyListenerToTab(){
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

    public Network(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("DisableNetworkAdapter [1]");
        button2 = new JButton("EnableNetworkAdapter [2]");
        button3 = new JButton("OpenNetworkAdapter [3]");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Disables active network adapter", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Enables active network adapter", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3,"Opens network adapter settings", font, KeyEvent.VK_3);

        //Add ActionListeners to all buttons
        addActionListenerToButton(button1, LinksNetwork.DISABLE_NETWORK_ADAPTER.getValue(), timer, tm, 10);
        addActionListenerToButton(button2, LinksNetwork.ENABLE_NETWORK_ADAPTER.getValue(), timer, tm, 10);
        addActionListenerToButton(button3, LinksNetwork.OPEN_NETWORK_ADAPTER.getValue(), timer, tm, 2);

        //Create tab-specific KeyListener
        listener6 = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener6);
        button2.addKeyListener(listener6);
        button3.addKeyListener(listener6);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[6];
        add(tabStatusLabel);
    }
}