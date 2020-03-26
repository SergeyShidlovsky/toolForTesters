package runner.tabs;

import runner.TimerTick;

import javax.swing.*;

public class Registry extends JPanel {

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    public void timeReset(int seconds, Timer timer, TimerTick tm) {
        timer.stop();             //Stopping previous timer before execution of current script
        tm.setCountdown(seconds); //Setting time of  Script execution
        timer.start();            //Starting timer after script initiation
    }
}
