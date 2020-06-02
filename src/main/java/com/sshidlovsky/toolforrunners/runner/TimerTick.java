package com.sshidlovsky.toolforrunners.runner;

import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Setter
public class TimerTick implements ActionListener {

    private Timer timer;
    private int countdown;
    private JLabel[] statusLabel;
    private static final String  STATUS_LABEL_CAPTION_GAP = "                                ";

    //Setting time remaining in all Labels on all Tabs
    public void actionPerformed(ActionEvent e) {
        countdown--;
        showTextOnAllLabels( "Wait time " + countdown);
        if (countdown == 0) {
            timer.stop();
            showTextOnAllLabels("Start Script");
        }
    }

    //method for displaying exception to failed script execution on all tabs
    public void showException() {
        timer.stop();
        showTextOnAllLabels("Script starting failed. Try again");
    }

    //Private method to setting text on all tabs
    private void showTextOnAllLabels(String text) {
        for (JLabel statusLabel : statusLabel) {
            statusLabel.setText(STATUS_LABEL_CAPTION_GAP + text  + STATUS_LABEL_CAPTION_GAP);
        }
    }
}
