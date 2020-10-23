package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksLinks;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Links extends JPanel {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;
    final JButton button6;
    final JButton button7;
    final JButton button8;
    final JButton button9;
    final JButton button10;
    final JButton button11;
    final JButton button12;
    private JLabel tabStatusLabel;
    private KeyListener listener5;
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

    public Links(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("Firmware [1]");
        button2 = new JButton("Builder [2]");
        button3 = new JButton("Builds [3]");
        button4 = new JButton("DeviceDoc [4]");
        button5 = new JButton(" DocumentationCUE 2.0 [5] ");
        button6 = new JButton("DocumentationCUE 3.0 [6]");
        button7 = new JButton(" Phabricator [7] ");
        button8 = new JButton("PMArea [8]");
        button9 = new JButton(" Report [9] ");
        button10 = new JButton("  Squash [0]   ");
        button11 = new JButton(" Test machines [-]   ");
        button12 = new JButton("  Wiki QA [=]   ");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Open page with FW images", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Open page with builder", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3,"Open page with builds", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4,"Open device documents page", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5,"Open CUE 2.0 documentation page", font, KeyEvent.VK_5);
        addButtonWithPreferencesToTab(button6,"Open CUE 3.0 documentation page", font, KeyEvent.VK_6);
        addButtonWithPreferencesToTab(button7,"Open Phabricator page", font, KeyEvent.VK_7);
        addButtonWithPreferencesToTab(button8,"Open PMArea", font, KeyEvent.VK_8);
        addButtonWithPreferencesToTab(button9,"Open report page", font, KeyEvent.VK_9);
        addButtonWithPreferencesToTab(button10,"Open squash page", font, KeyEvent.VK_0);
        addButtonWithPreferencesToTab(button11,"Open page with stend machines list", font, KeyEvent.VK_MINUS);
        addButtonWithPreferencesToTab(button12,"Open QA Section of Project Wiki", font, KeyEvent.VK_EQUALS);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksLinks.FIRMWARE.getValue(), timer, tm, 2);
        addActionListenerToButton(button2, LinksLinks.BUILDER.getValue(), timer, tm, 2);
        addActionListenerToButton(button3, LinksLinks.BUILDS.getValue(), timer, tm, 2);
        addActionListenerToButton(button4, LinksLinks.DEVICE_INFO.getValue(), timer, tm, 2);
        addActionListenerToButton(button5, LinksLinks.DOCUMENTATION_CUE_2_0.getValue(), timer, tm, 2);
        addActionListenerToButton(button6, LinksLinks.DOCUMENTATION_CUE_3_0.getValue(), timer, tm, 2);
        addActionListenerToButton(button7, LinksLinks.PHABRICATOR.getValue(), timer, tm, 2);
        addActionListenerToButton(button8, LinksLinks.PM_AREA.getValue(), timer, tm, 2);
        addActionListenerToButton(button9, LinksLinks.REPORT.getValue(), timer, tm, 2);
        addActionListenerToButton(button10, LinksLinks.SQUASH.getValue(), timer, tm, 2);
        addActionListenerToButton(button11, LinksLinks.TEST_MACHINES.getValue(), timer, tm, 2);
        addActionListenerToButton(button12, LinksLinks.WIKI_QA.getValue(), timer, tm, 2);

        //Create tab-specific KeyListener
        listener5 = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        button1.addKeyListener(listener5);
        button2.addKeyListener(listener5);
        button3.addKeyListener(listener5);
        button4.addKeyListener(listener5);
        button5.addKeyListener(listener5);
        button6.addKeyListener(listener5);
        button7.addKeyListener(listener5);
        button8.addKeyListener(listener5);
        button9.addKeyListener(listener5);
        button10.addKeyListener(listener5);
        button11.addKeyListener(listener5);
        button12.addKeyListener(listener5);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[5];
        add(tabStatusLabel);
    }
}