package java.com.sshidlovsky.toolforrunners;

import com.sshidlovsky.toolforrunners.runner.TimerTick;
import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.*;

public class Testing {

    @Test
    public void testShowTimerException() {
        TimerTick tm = new TimerTick();

        JLabel labelOne = new JLabel();
        JLabel labelTwo = new JLabel();
        JLabel labelThree = new JLabel();

        labelOne.setText("OriginalNameOne");
        labelTwo.setText("OriginalNameTwo");
        labelThree.setText("OriginalNameThree");

        JLabel statusLabel[] = new JLabel[2];

        statusLabel[0] = labelOne;
        statusLabel[1] = labelTwo;
        statusLabel[2] = labelThree;

        tm.showException();
        assertEquals("Wrong exception caption",
                     "                   Script starting failed. Try again                  ",
                    statusLabel[0].getText());

    }
}
