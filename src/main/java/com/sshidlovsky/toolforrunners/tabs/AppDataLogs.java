package com.sshidlovsky.toolforrunners.tabs;

import com.sshidlovsky.toolforrunners.linkenums.LinksAppDataLogs;
import com.sshidlovsky.toolforrunners.runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppDataLogs extends JPanel {

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
    private KeyListener listener0;

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of Script execution
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

    public AppDataLogs(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        //Create list of buttons
        button1 = new JButton("Clean Logs [1] ");
        button2 = new JButton("Clean ProgrammData [2] ");
        button3 = new JButton("Clear AppData [3] ");
        button4 = new JButton("Get Archive Appdata [4] ");
        button5 = new JButton("Get Archive ProgramData [5] ");
        button6 = new JButton("Get Last Archived Program AppData [6] ");
        button7 = new JButton("Get Last Log [7] ");
        button8 = new JButton("Open AppData [8] ");
        button9 = new JButton("Open Debug Service Folder [9] ");
        button10 = new JButton("Open Folder With Archived Program App Data [-] ");
        button11 = new JButton("Open Logs [=] ");
        button12 = new JButton("Open Program Data [q] ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Clean Logs", font);
        addButtonWithPreferencesToTab(button2, "lean ProgrammData", font);
        addButtonWithPreferencesToTab(button3, "Clear AppData", font);
        addButtonWithPreferencesToTab(button4, "Get Archive Appdata", font);
        addButtonWithPreferencesToTab(button5, "Get Archive ProgramData", font);
        addButtonWithPreferencesToTab(button6, "Get Last Archived Program AppData", font);
        addButtonWithPreferencesToTab(button7, "et Last Log", font);
        addButtonWithPreferencesToTab(button8, "Open AppData", font);
        addButtonWithPreferencesToTab(button9, "Open Debug Service Folder", font);
        addButtonWithPreferencesToTab(button10, "Open Folder With Archived Program App Data", font);
        addButtonWithPreferencesToTab(button11, "Open Logs", font);
        addButtonWithPreferencesToTab(button12, "Open Program Data", font);

        //Add ActionListeners to all buttons
        addActionListenerToButton(button1, LinksAppDataLogs.CLEAN_LOGS.getValue(), timer, tm, 3);
        addActionListenerToButton(button2, LinksAppDataLogs.CLEAN_PROGRAMDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button3, LinksAppDataLogs.CLEAR_APPDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button4, LinksAppDataLogs.GET_ARCIVE_APPDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button5, LinksAppDataLogs.GET_ARCHIVE_PROGRAMDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button6, LinksAppDataLogs.GET_LAST_ARHIVED_PROGRAMDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button7, LinksAppDataLogs.GET_LAST_LOG.getValue(), timer, tm, 3);
        addActionListenerToButton(button8, LinksAppDataLogs.OPEN_APPDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button9, LinksAppDataLogs.OPEN_DEBUG_SERVICE_FOLDER.getValue(), timer, tm, 3);
        addActionListenerToButton(button10, LinksAppDataLogs.OPEN_FOLDER_WITH_ARCHIVED_PROGRAM_APPDATA.getValue(), timer, tm, 3);
        addActionListenerToButton(button11, LinksAppDataLogs.OPEN_LOGS.getValue(), timer, tm, 3);
        addActionListenerToButton(button12, LinksAppDataLogs.OPEN_PROGRAM_DATA.getValue(), timer, tm, 3);

        //Add KeyListener for all Buttons' press emulation
        listener0 = new KeyAdapter() {
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
        button1.addKeyListener(listener0);
        button2.addKeyListener(listener0);
        button3.addKeyListener(listener0);
        button4.addKeyListener(listener0);
        button5.addKeyListener(listener0);
        button6.addKeyListener(listener0);
        button7.addKeyListener(listener0);
        button8.addKeyListener(listener0);
        button9.addKeyListener(listener0);
        button10.addKeyListener(listener0);
        button11.addKeyListener(listener0);
        button12.addKeyListener(listener0);

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[0];
        add(tabStatusLabel);
    }
}
