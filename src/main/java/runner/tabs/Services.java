package runner.tabs;

import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Services extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Services(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        final JButton button1 = new JButton("Open Services [1]");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Open Services window");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("Start Audio Service [2]");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Start Audio Service.");
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton("Start Integration Service [3]");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Start Integration Service");
        button3.setSize(313, 110);
        add(button3);

        final JButton button4 = new JButton("Stop Audio Service [4]");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("Stop Audio Service");
        button4.setSize(313, 110);
        add(button4);

        final JButton button5 = new JButton("Stop Integration Service [5]");
        button5.setFont(font);
        button5.setVisible(true);
        button5.setToolTipText("Stop Integration Service");
        button5.setSize(313, 110);
        add(button5);

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\myRepos\\toolForTesters\\src\\main\\java\\runner\\scripts\\services\\OpenServices.bat");
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
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Services\\StartAudioService.bat");
                        timeReset(3, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button3
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Services\\StartIntegrationService.bat");
                        timeReset(4, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button4
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Services\\StopAudioService.bat");
                        timeReset(3, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add ActionListeners of Button5
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button5) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Services\\StopIntegrationService.bat");
                        timeReset(5, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
        KeyListener listener8 = new KeyAdapter() {
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
                }
            }
        };

        button1.addKeyListener(listener8);
        button2.addKeyListener(listener8);
        button3.addKeyListener(listener8);
        button4.addKeyListener(listener8);
        button5.addKeyListener(listener8);
        add(statusLabel[8]);
        this.addKeyListener(listener8);
    }
}