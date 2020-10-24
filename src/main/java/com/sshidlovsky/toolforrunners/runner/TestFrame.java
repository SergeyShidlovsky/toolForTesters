package com.sshidlovsky.toolforrunners.runner;

import com.sshidlovsky.toolforrunners.tabs.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */

public class TestFrame extends JFrame {

    int quantity = 9;
    private Timer timer;
    protected Font font;
    protected Font labelFont;
    protected JLabel[] statusLabel;
    protected JTabbedPane tabbedPane;

    public TestFrame() {

        super("Tool For QA Engineers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font of Buttons and Labels
        font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        labelFont  = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        //Creating tabbed pane with font
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        //Creating an array of statusLabels
        statusLabel = new JLabel[quantity];
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

        //Adding Common timer to our tool,
        timer = new Timer(1000, tm);
        tm.setTimer(timer);

        //Adding all tabs to tabbed pane
        tabbedPane.addTab("AppDataLogs", new AppDataLogs(timer, tm, font, statusLabel));
        tabbedPane.addTab("Application", new Application(timer, tm, font, statusLabel));
        tabbedPane.addTab("Dumps", new Dumps(timer, tm, font, statusLabel));
        tabbedPane.addTab("Execute", new Execute(timer, tm, font, statusLabel));
        tabbedPane.addTab("Installation", new Installation(timer, tm, font, statusLabel));
        tabbedPane.addTab("Links", new Links(timer, tm, font, statusLabel));
        tabbedPane.addTab("Network", new Network(timer, tm, font, statusLabel));
        tabbedPane.addTab("Registry", new Registry(timer, tm, font, statusLabel));
        tabbedPane.addTab("Services", new Services(timer, tm, font, statusLabel));

        //Adding tabbed pane to jFrame and Setting preferences
        setPreferredSize(new Dimension(655, 215));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(tabbedPane);
    }
}
