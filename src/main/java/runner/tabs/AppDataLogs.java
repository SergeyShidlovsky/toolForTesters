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

        //Add ActionListeners of Button1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button1 will perform next act Grabilla screen capture: 2018-04-02 15:37:28ions
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

        //Add ActionListeners of Button2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button2 will perform next actions
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
