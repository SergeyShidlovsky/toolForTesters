package runner.tabs;

import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Links extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Links(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {
        final JButton button1 = new JButton("Phabricator [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Open https://git.devx.dp.ua");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("Builder [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Open Builder");
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton("Documentation [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Open Documentation folder on FS ");
        button3.setSize(313, 110);
        add(button3);

        final JButton button4 = new JButton("Builds [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("Open Builds ");
        button4.setSize(313, 110);
        add(button4);

        final JButton button5 = new JButton(" Firmware [5] ");
        button5.setFont(font);
        button5.setVisible(true);
        button5.setToolTipText("Open storage with Corsair Firmware");
        button5.setSize(313, 110);
        add(button5);

        final JButton button6 = new JButton("Report [6]");
        button6.setFont(font);
        button6.setVisible(true);
        button6.setToolTipText("Open GoogleDoc with Reports and Tasks");
        button6.setSize(313, 110);
        add(button6);

        final JButton button7 = new JButton(" PMArea [7] ");
        button7.setFont(font);
        button7.setVisible(true);
        button7.setToolTipText("Open PMAreya");
        button7.setSize(313, 110);
        add(button7);

        final JButton button8 = new JButton("Squash [8]");
        button8.setFont(font);
        button8.setVisible(true);
        button8.setToolTipText("Open Squash");
        button8.setSize(313, 110);
        add(button8);

        final JButton button9 = new JButton(" Wiki All [9] ");
        button9.setFont(font);
        button9.setVisible(true);
        button9.setToolTipText("Open Project Wiki");
        button9.setSize(313, 110);
        add(button9);

        final JButton button10 = new JButton("  Wiki QA [0]   ");
        button10.setFont(font);
        button10.setVisible(true);
        button10.setToolTipText("Open QA Section of Progect Wiki");
        button10.setSize(313, 110);
        add(button10);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("%APPDATA%\\111\\OpenGit.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenBuilder.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenDocumentation.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenBuilds.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\Firmware.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenReport.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenPMArea.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button8
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button8 will perform next actions
                if (ae.getSource() == button8) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenSquash.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button9
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button9 will perform next actions
                if (ae.getSource() == button9) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenWikiALL.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button10
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button10 will perform next actions
                if (ae.getSource() == button10) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenWikiQA.bat");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button press
        KeyListener listener5 = new KeyAdapter() {
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
                    case KeyEvent.VK_8:
                        button8.doClick();
                        break;
                    case KeyEvent.VK_9:
                        button9.doClick();
                        break;
                    case KeyEvent.VK_0:
                        button10.doClick();
                        break;
                }
            }
        };

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
        add(statusLabel[5]);
        this.addKeyListener(listener5);
    }
}
