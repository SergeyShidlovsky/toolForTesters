package com.sshidlovsky.toolforrunners.runner;

import com.sshidlovsky.toolforrunners.tabs.*;

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
        }

        tabbedPane.addTab("AppDataLogs", new AppDataLogs(timer, tm, font, statusLabel) {
        });

        tabbedPane.addTab("Application", new Application(timer, tm, font, statusLabel) {
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
