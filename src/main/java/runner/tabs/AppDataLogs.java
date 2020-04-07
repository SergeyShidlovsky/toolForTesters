package runner.tabs;

import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppDataLogs extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public AppDataLogs(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {
        //Configure visual settings of Button1
        final JButton button1 = new JButton("Clean Logs [1]");
        button1.setFont(font);
        button1.setToolTipText("Opens %Appata% folder");
        button1.setSize(313, 110);
        add(button1);

        //Configure visual setting of Button2
        final JButton button2 = new JButton("Clean ProgrammData [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Opens CUE Log folder");
        button2.setSize(313, 110);
        add(button2);

        //Configure visual setting of Button3
        final JButton button3 = new JButton("Clear AppData [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setSize(313, 110);
        add(button3);

        //Configure visual setting of Button4
        final JButton button4 = new JButton("Get Archive Appdata [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setSize(313, 110);
        add(button4);

        //Configure visual setting of Button5
        final JButton button5 = new JButton("Get Archive ProgramData [5]");
        button5.setFont(font);
        button5.setVisible(true);
        button5.setSize(313, 110);
        add(button5);

        //Configure visual setting of Button6
        final JButton button6 = new JButton("Get Last Archived Program AppData [6]");
        button6.setFont(font);
        button6.setVisible(true);
        button6.setSize(313, 110);
        add(button6);

        //Configure visual setting of Button7
        final JButton button7 = new JButton("Get Last Log [7]");
        button7.setFont(font);
        button7.setVisible(true);
        button7.setSize(313, 110);
        add(button7);

        //Configure visual setting of Button8
        final JButton button8 = new JButton("Open AppData [8]");
        button8.setFont(font);
        button8.setVisible(true);
        button8.setSize(313, 110);
        add(button8);

        //Configure visual setting of Button9
        final JButton button9 = new JButton("Open Debug Service Folder [9]");
        button9.setFont(font);
        button9.setVisible(true);
        button9.setSize(313, 110);
        add(button9);

        //Configure visual setting of Button10
        final JButton button10 = new JButton("Open Folder With Archived Program App Data [-]");
        button10.setFont(font);
        button10.setVisible(true);
        button10.setSize(313, 110);
        add(button10);

        //Configure visual setting of Button11
        final JButton button11 = new JButton("Open Logs [=]");
        button11.setFont(font);
        button11.setVisible(true);
        button11.setSize(313, 110);
        add(button11);

        //Configure visual setting of Button12
        final JButton button12 = new JButton("Open Program Data.bat [q]");
        button12.setFont(font);
        button12.setVisible(true);
        button12.setToolTipText("Opens CUE Log folder");
        button12.setSize(313, 110);
        add(button12);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\CleanLogs.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\CleanProgrammData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\ClearAppData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetArchiveAppdata.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetArchiveProgramData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetLastArchivedProgramAppData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetLastLog.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenAppData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenDebugServiceFolder.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenFolderWithArchivedPrgramAppData.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenProgramData.bat");
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for APPDATAandLOGS  BUTTONS clicking emulation by pressing NumPad buttons
        KeyListener listener0 = new KeyAdapter() {
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

        button1.addKeyListener(listener0);
        this.add(add(statusLabel[0]));
        this.addKeyListener(listener0);
    }
}
