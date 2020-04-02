package runner;

import runner.tabs.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */

public class TestFrame extends JFrame {

    //Set quantity of tabs Here
    int quantity = 9;

    private JLabel[] statusLabel = new JLabel[quantity]; //Creating array of labels
    private Timer timer;

    public TestFrame() {

        super("Tool For QA Engineers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font of Buttons
        final Font font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font of Label
        final Font labelFont = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 20);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        //Adding Status Labels  on each  Tab that is
        //running down time of scripts execution
        for (int i = 0; i < quantity; i++) {
            statusLabel[i] = new JLabel("                      Start Script                      ");
            statusLabel[i].setFont(labelFont);
            statusLabel[i].setVisible(true);
            statusLabel[i].setSize(313, 110);
            statusLabel[i].setHorizontalAlignment(2);
            statusLabel[i].setLocation(200, 200);
        }

        //Adding timer execution
        final TimerTick tm = new TimerTick();
        tm.setStatusLabel(statusLabel);

        //Adding Common timer to our tool, by creation
        //an object of Timer Tick Class
        final Timer timer = new Timer(1000, tm);
        tm.setTimer(timer);

        class AppDataLogs0 extends JPanel {

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            AppDataLogs0() {

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

                //Adding status label on First tab
                add(statusLabel[0]);


                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next act Grabilla screen capture: 2018-04-02 15:37:28ions
                        if (ae.getSource() == button1) {
                            try {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\Firmwar1234214e.bat");
                                timeReset(10); //Set time of Script Execution Here
                            } catch (Exception r) {
                                tm.showException();
                            }
                        }
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if (ae.getSource() == button2) {
                            try {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
                                timeReset(4); //Set time of Script Execution Here
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

        //Class that displays time running down after script is started


        class Application1 extends JPanel {

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {

                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Application1() {

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
                                timeReset(1); //Set time of Script Execution Here
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
                                timeReset(3); //Set time of Script Execution Here
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
                                timeReset(1); //Set time of Script Execution Here
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
                                timeReset(1); //Set time of Script Execution Here
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
                                timeReset(1); //Set time of Script Execution Here
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
                                timeReset(1); //Set time of Script Execution Here
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
                                timeReset(1); //Set time of Script Execution Here
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

        tabbedPane.addTab("AppDataLogs", new AppDataLogs0() {
        });

        tabbedPane.addTab("Application", new Application1() {
        });

        tabbedPane.addTab("Dumps", new Dumps(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Execute", new Execute(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Installation", new Installation(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Links", new Links(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Network", new Network(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Registry", new Registry(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Services", new Services(timer, tm, font, statusLabel) {
        });

        setPreferredSize(new Dimension(645, 215));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(tabbedPane);
    }
}
