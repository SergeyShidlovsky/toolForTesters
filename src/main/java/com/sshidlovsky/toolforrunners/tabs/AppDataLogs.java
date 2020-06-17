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
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
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

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.CLEAN_LOGS.getValue());
                        timeReset(10, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.CLEAN_PROGRAMDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.CLEAR_APPDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.GET_ARCIVE_APPDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button5) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.GET_ARCHIVE_PROGRAMDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button6) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.GET_LAST_ARHIVED_PROGRAMDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button7) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.GET_LAST_LOG.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button8) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.OPEN_APPDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button9) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.OPEN_DEBUG_SERVICE_FOLDER.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button10) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.OPEN_FOLDER_WITH_ARCHIVED_PROGRAM_APPDATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button11) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.OPEN_LOGS.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button12) {
                    try {
                        Runtime.getRuntime().exec(LinksAppDataLogs.OPEN_PROGRAM_DATA.getValue());
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
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

        //Add StatusLabel to tab
        tabStatusLabel = statusLabel[0];
        add(tabStatusLabel);
    }
}
