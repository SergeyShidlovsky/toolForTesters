package runner.tabs;

import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Application(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {
        //Configure visual settings of Button1
        final JButton button1 = new JButton("Open Appdata [1]");
        button1.setFont(font);
        button1.setToolTipText("Opens %Appata% folder");
        button1.setSize(313, 110);
        add(button1);

        //Configure visual setting of Button2
        final JButton button2 = new JButton("Open logs [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Opens CUE Log folder");
        button2.setSize(313, 110);
        add(button2);

        //Configure visual settings of Button3
        final JButton button3 = new JButton("Clear Appdata [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Delete CUE %Appata% folder");
        button3.setSize(313, 110);
        add(button3);

        //Configure visual setting of Button4
        final JButton button4 = new JButton("Clear logs [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("Delete CUE Log folder");
        button4.setSize(313, 110);
        add(button4);

        //Configure visual setting of Button5
        final JButton button5 = new JButton("Get Last log [5]");
        button5.setFont(font);
        button5.setVisible(true);
        button5.setToolTipText("Select last log and copy it to Desktop");
        button5.setSize(313, 110);
        add(button5);

        //Configure visual setting of Button6
        final JButton button6 = new JButton("Get AppData [6]");
        button6.setFont(font);
        button6.setVisible(true);
        button6.setToolTipText("Compress AppData to *.zip and copy to Desktop");
        button6.setSize(313, 110);
        add(button6);

        //Configure visual setting of Button7
        final JButton button7 = new JButton("      RestartWithClearedAppdata [7]     ");
        button7.setFont(font);
        button7.setVisible(true);
        button7.setToolTipText("Restart application with cleared Appdata");
        button7.setSize(313, 110);
        add(button7);

        // ДОПИСАТЬ ЭМУЛЯЦИЮ НАЖАТОЙ КНОПКИ ТАБ

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenAppData.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
                // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
            }
        });

        //Add ActionListeners of Button2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
                        timeReset(3, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button3
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button3 will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\ClearAppData.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button4
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button4 will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\CleanLogs.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button5
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button5 will perform next actions
                if (ae.getSource() == button5) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetLastLog.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button6
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button6 will perform next actions
                if (ae.getSource() == button6) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetArchiveAppdata.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button7
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button7 will perform next actions
                if (ae.getSource() == button7) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\RestartClearedApp.bat");
                        timeReset(1, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for APPDATAandLOGS  BUTTONS clicking emulation by pressing NumPad buttons
        KeyListener listener = new KeyAdapter() {
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
                    case KeyEvent.VK_6:
                        button6.doClick();
                        break;
                    case KeyEvent.VK_7:
                        button7.doClick();
                        break;
                }
            }
        };

        button1.addKeyListener(listener);
        add(statusLabel[1]);
        this.addKeyListener(listener);
    }
}
