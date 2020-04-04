package com.sshidlovsky.toolforrunners.runner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerTick implements ActionListener {

    int countdown;           //Value of time of script;s execution
    Timer timer;             //Created object of "Timer" type
    JLabel statusLabel[];    //Created array of Labels

    public void setStatusLabel(JLabel[] statusLabel) {
        this.statusLabel = statusLabel;
    }

    //todo: Use lombok
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    //todo: Use lombok
    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }
    //todo: Use lombok
    //setting time remaining in all Label on all Tabs
    public void actionPerformed(ActionEvent e) {

        countdown--;
        //ToDo User forEach loop and move test setter to separate method
        for (int i = 0; i < statusLabel.length; i++) {
            //Todo: Move spases to Gap String variable and add it to beautify the code
            statusLabel[i].setText("                                Wait time " + String.valueOf(countdown) +
                    "                                ");
        }

        if (countdown == 0) {
            timer.stop();
            //ToDo User forEach loop and move test setter to separate method
            for (int i = 0; i < statusLabel.length; i++) {
                //Todo: Move spases to Gap String variable and add it to beautify the code
                statusLabel[i].setText("                                Start Script                                ");
            }
        }
    }

    //method for displaying exception of failed script execution on all tabs
    public void showException() {
        timer.stop();
        //ToDo User forEach loop and move test setter to separate method
        for (int i = 0; i < statusLabel.length; i++) {
            //Todo: Move spases to Gap String variable and add it to beautify the code
            statusLabel[i].setText("                   Script starting failed. Try again                  ");
        }
    }
}
