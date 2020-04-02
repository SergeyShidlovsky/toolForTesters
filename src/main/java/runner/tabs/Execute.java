package runner.tabs;

import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Execute extends JPanel  {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    //todo Move this method to abstract class
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }

    public Execute(final Timer timer, final TimerTick tm, Font font, JLabel[] statusLabel) {

        final JButton button1 = new JButton("Device and Printers");
        button1.setFont(font);
        button1.setVisible(true);
        button1.setToolTipText("Open Device and Printers");
        button1.setSize(313, 110);
        add(button1);

        final JButton button2 = new JButton("Device Manager");
        button2.setFont(font);
        button2.setVisible(true);
        button2.setToolTipText("Open Device manger");
        button2.setSize(313, 110);
        add(button2);

        final JButton button3 = new JButton(" Application wizard ");
        button3.setFont(font);
        button3.setVisible(true);
        button3.setToolTipText("Open Application wizard");
        button3.setSize(313, 110);
        add(button3);

        final JButton button4 = new JButton(" Registry Editor");
        button4.setFont(font);
        button4.setVisible(true);
        button4.setToolTipText("Open Registry Editor");
        button4.setSize(313, 110);
        add(button4);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next actions
                if (ae.getSource() == button1) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
                if (ae.getSource() == button2) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button3 will perform next actions
                if (ae.getSource() == button3) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button4 will perform next actions
                if (ae.getSource() == button4) {
                    try {
                        Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                        timeReset(2, timer, tm); //Set time of Script Execution Here
                    } catch (Exception r) {
                        tm.showException();
                    }
                }
            }
        });

        //Add KeyListener for Button1 press emulation by pressing Num1 button
        KeyListener listener3 = new KeyAdapter() {
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
                }
            }
        };

        button1.addKeyListener(listener3);
        add(statusLabel[3]);
        this.addKeyListener(listener3);
    }
}
