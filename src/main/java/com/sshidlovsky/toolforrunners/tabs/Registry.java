package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinkRegistry;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Registry extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    private JLabel tabStatusLabel;
    private KeyListener listener7;
    private Map<Integer, JButton> buttonAssignment;

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

    public Registry(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("OpenRegistryEditor [1]");
        button2 = new JButton("OpenRegistryEditorClinkPIDs [2]");
        button3 = new JButton("OpenRegistryEditorErrorReporting [3]");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Opens Registry Editor", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Open Registry Editor Clink PIDs", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button2,"Open Registry Editor Error Reporting", font, KeyEvent.VK_3);

        //Add ActionListeners to all Buttons
        addActionListenerToButton(button1, LinkRegistry.OPEN_REGISTRY_EDITOR.getValue(),timer,tm,2);
        addActionListenerToButton(button2, LinkRegistry.OPEN_REGISTRY_EDITOR_CLINK_PIDS.getValue(), timer, tm, 2);
        addActionListenerToButton(button3, LinkRegistry.OPEN_REGISTRY_EDITOR_ERROR_REPORTING.getValue(), timer, tm, 2);

        //Create tab-specific KeyListener
        listener7 = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener7);
        button2.addKeyListener(listener7);
        button3.addKeyListener(listener7);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[7];
        add(tabStatusLabel);
    }
}