package com.sshidlovsky.toolforrunners;

import com.sshidlovsky.toolforrunners.runner.TimerTick;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class Testing {

    private TimerTick tm = new TimerTick();
    private Timer timer = new Timer(1000, tm);
    private JLabel[] statusLabels;
    private static final String STATUS_LABEL_CAPTION_GAP = "                                ";

    @Test
    public void testSetGetCountdown(){
        int countdownExpectedValue = 10;
        tm.setCountdown(countdownExpectedValue);
        int countdownActualValue = tm.getCountdown();
        assertEquals("Countdown isn't set", countdownExpectedValue, countdownActualValue);
    }

    @Test
    public void getSetGetStatusLabels(){
        JLabel labelOne = new JLabel();
        JLabel labelTwo = new JLabel();
        JLabel labelThree = new JLabel();
        statusLabels = new JLabel[] {labelOne, labelTwo, labelThree};
        tm.setStatusLabel(statusLabels);
        for (int i = 0; i < statusLabels.length ; i++) {
            assertEquals("Label " + i + "isn't  put into array", statusLabels[i], tm.getStatusLabel()[i]);
        }
    }

    @Test
    public void testShowTimerException() {

        tm.setTimer(timer);

        JLabel labelOne = new JLabel();
        JLabel labelTwo = new JLabel();
        JLabel labelThree = new JLabel();

        labelOne.setText("OriginalNameOne");
        labelTwo.setText("OriginalNameTwo");
        labelThree.setText("OriginalNameThree");

        JLabel[] statusLabel = new JLabel[3];

        statusLabel[0] = labelOne;
        statusLabel[1] = labelTwo;
        statusLabel[2] = labelThree;

        tm.setStatusLabel(statusLabel);
        timer.start();
        tm.showException();
        assertEquals("Wrong exception caption", STATUS_LABEL_CAPTION_GAP + "Script starting failed. Try again" +
                        STATUS_LABEL_CAPTION_GAP,
                statusLabel[0].getText());
    }
}
