package runner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerTick implements ActionListener {

    int countdown;           //Value of time of script;s execution
    Timer timer;             //
    JLabel statusLabel[];

    public void setStatusLabel(JLabel[] statusLabel) {
        this.statusLabel = statusLabel;
    }


    public void setTimer(Timer timer) {
        this.timer = timer;
    }



    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    //setting time remaining in all Label on all Tabs
    public void actionPerformed(ActionEvent e) {

        countdown--;
        for (int i = 0; i < statusLabel.length; i++) {

            statusLabel[i].setText("                      Wait time " + String.valueOf(countdown) +
                    "                       ");
        }

        if (countdown == 0) {
            timer.stop();
            for (int i = 0; i < statusLabel.length; i++) {
                statusLabel[i].setText("                      Start Script                      ");
            }
        }
    }

    //method for displaying exception of failed script execution on all tabs
    public void showException() {
        timer.stop();
        for (int i = 0; i < statusLabel.length; i++) {

            statusLabel[i].setText("              Script starting failed. Try again             ");
        }
    }
}
