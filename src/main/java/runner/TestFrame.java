package toolForRunners;
import runner.TimerTick;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */

//See changelog.txt for qny questions

public class TestFrame extends JFrame {

    //Set quantity of tabs Here
    int quantity = 6;

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
            statusLabel[i].setSize(313,110);
            statusLabel[i].setHorizontalAlignment(2);
            statusLabel[i].setLocation(200,200);
        }

        //Adding timer execution
        final TimerTick tm = new TimerTick();
        tm.setStatusLabel(statusLabel);

        //Adding Common timer to our tool, by creation
        //an exsemplair of Timer Tick Class
        final Timer timer = new Timer(1000, tm);
        tm.setTimer(timer);

        class Template extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Template () {

                //Configure visual settings of Button1
                final JButton button1 = new JButton("Open Appdata [1]");
                button1.setFont(font);
                button1.setToolTipText("Opens %Appata% folder");
                button1.setSize(313, 110);
                add(button1);

                //Configure visual setting of Button2
                final JButton button2 = new JButton("Open logs [2]");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setToolTipText("Opens CUE Log folder");
                button2.setSize(313, 110);
                add(button2);

                //Adding status label on First tab
                add(statusLabel[0]);


                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next act Grabilla screen capture: 2018-04-02 15:37:28ions
                        if (ae.getSource() == button1) {
                            try {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenAppData.bat");
                                timeReset(10); //Set time of Script Execution Here
                            } catch (Exception r) {
                            }
                        }
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if (ae.getSource() == button2) {
                            try {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
                                timeReset(2); //Set time of Script Execution Here
                            } catch (Exception r) {}
                        }
                    }
                });

                //Add KeyListener for APPDATAandLOGS  BUTTONS clicking emulation by pressing NumPad buttons
                KeyListener listener = new KeyAdapter() {
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

                button1.addKeyListener(listener);
                this.add(add(statusLabel[0]));
                this.addKeyListener(listener);

            }
        }

        //Class that displays time running down after script is started


        class AppDataLogs1 extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {

                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            AppDataLogs1 () {

                //Configure visual settings of Button1
                final JButton button1 = new JButton("Open Appdata [1]");
                button1.setFont(font);
                button1.setToolTipText("Opens %Appata% folder");
                button1.setSize(313, 110);
                add(button1);

                //Configure visual setting of Button2
                final JButton button2 = new JButton("Open logs [2]");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setToolTipText("Opens CUE Log folder");
                button2.setSize(313, 110);
                add(button2);

                //Configure visual settings of Button3
                final JButton button3 = new JButton("Clear Appdata [3]");
                button3.setFont(font);
                button3.setVisible(true);
                button3.setToolTipText("Delete CUE %Appata% folder");
                button3.setSize(313, 110);
                add(button3);

                //Configure visual setting of Button4
                final JButton button4 = new JButton("Clear logs [4]");
                button4.setFont(font);
                button4.setVisible(true);
                button4.setToolTipText("Delete CUE Log folder");
                button4.setSize(313, 110);
                add(button4);

                //Configure visual setting of Button5
                final JButton button5 = new JButton("Get Last log [5]");
                button5.setFont(font);
                button5.setVisible(true);
                button5.setToolTipText("Select last log and copy it to Desktop");
                button5.setSize(313, 110);
                add(button5);

                //Configure visual setting of Button6
                final JButton button6 = new JButton("Get AppData [6]");
                button6.setFont(font);
                button6.setVisible(true);
                button6.setToolTipText("Compress AppData to *.zip and copy to Desktop");
                button6.setSize(313, 110);
                add(button6);

                //Configure visual setting of Button7
                final JButton button7 = new JButton("      RestartWithClearedAppdata [7]     ");
                button7.setFont(font);
                button7.setVisible(true);
                button7.setToolTipText("Restart application with cleared Appdata");
                button7.setSize(313, 110);
                add(button7);

                // ДОПИСАТЬ ЭМУЛЯЦИЮ НАЖАТОЙ КНОПКИ ТАБ

                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenAppData.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                        // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
                                timeReset(3); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button3
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button3 will perform next actions
                        if(ae.getSource() == button3)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\ClearAppData.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button4
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button4 will perform next actions
                        if(ae.getSource() == button4)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\CleanLogs.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button5
                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button5 will perform next actions
                        if(ae.getSource() == button5)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetLastLog.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button6
                button6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button6 will perform next actions
                        if(ae.getSource() == button6)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\GetArchiveAppdata.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button7
                button7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button7 will perform next actions
                        if(ae.getSource() == button7)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\RestartClearedApp.bat");
                                timeReset(1); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add KeyListener for APPDATAandLOGS  BUTTONS clicking emulation by pressing NumPad buttons
                KeyListener listener = new KeyAdapter() {
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
                            case KeyEvent.VK_5:
                                button5.doClick();
                                break;
                            case KeyEvent.VK_6:
                                button6.doClick();
                                break;
                            case KeyEvent.VK_7:
                                button7.doClick();
                                break;
                        }
                    }
                };

                button1.addKeyListener(listener);
                add(statusLabel[1]);
                this.addKeyListener(listener);

            }

        }

        class Link2 extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Link2 () {
                final JButton button1 = new JButton("  Phabricator [1]   ");
                button1.setFont(font);
                button1.setVisible(true);
                button1.setToolTipText("Open https://git.devx.dp.ua");
                button1.setSize(313, 110);
                add(button1);

                final JButton button2 = new JButton("  Builder [2] ");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setToolTipText("Open Builder");
                button2.setSize(313, 110);
                add(button2);

                final JButton button3 = new JButton("Documentation [3]");
                button3.setFont(font);
                button3.setVisible(true);
                button3.setToolTipText("Open Documentation folder on FS ");
                button3.setSize(313, 110);
                add(button3);

                final JButton button4 = new JButton("  Builds [4]  ");
                button4.setFont(font);
                button4.setVisible(true);
                button4.setToolTipText("Open Builds ");
                button4.setSize(313, 110);
                add(button4);

                final JButton button5 = new JButton("   Firmware [5]   ");
                button5.setFont(font);
                button5.setVisible(true);
                button5.setToolTipText("Open storage with Corsair Firmware");
                button5.setSize(313, 110);
                add(button5);

                final JButton button6 = new JButton("  Report [6]    ");
                button6.setFont(font);
                button6.setVisible(true);
                button6.setToolTipText("Open GoogleDoc with Reports and Tasks");
                button6.setSize(313, 110);
                add(button6);

                final JButton button7 = new JButton("   PMArea [7]   ");
                button7.setFont(font);
                button7.setVisible(true);
                button7.setToolTipText("Open PMAreya");
                button7.setSize(313, 110);
                add(button7);

                final JButton button8 = new JButton("   Squash [8]    ");
                button8.setFont(font);
                button8.setVisible(true);
                button8.setToolTipText("Open Squash");
                button8.setSize(313, 110);
                add(button8);

                final JButton button9 = new JButton("   Wiki All [9]   ");
                button9.setFont(font);
                button9.setVisible(true);
                button9.setToolTipText("Open Project Wiki");
                button9.setSize(313, 110);
                add(button9);

                final JButton button10 = new JButton("  Wiki QA [0]   ");
                button10.setFont(font);
                button10.setVisible(true);
                button10.setToolTipText("Open QA Section of Progect Wiki");
                button10.setSize(313, 110);
                add(button10);

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("%APPDATA%\\111\\OpenGit.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenBuilder.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button3
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button3 will perform next actions
                        if(ae.getSource() == button3)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenDocumentation.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button4
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button4 will perform next actions
                        if(ae.getSource() == button4)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenBuilds.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button5
                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button5 will perform next actions
                        if(ae.getSource() == button5)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\Firmware.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button6
                button6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button6 will perform next actions
                        if(ae.getSource() == button6)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenReport.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button7
                button7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button7 will perform next actions
                        if(ae.getSource() == button7)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenPMArea.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button8
                button8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button8 will perform next actions
                        if(ae.getSource() == button8)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenSquash.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button9
                button9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button9 will perform next actions
                        if(ae.getSource() == button9)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenWikiALL.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button10
                button10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button10 will perform next actions
                        if(ae.getSource() == button10)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenWikiQA.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add KeyListener for Button1 press emulation by pressing Num1 button
                KeyListener listener2 = new KeyAdapter() {
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
                            case KeyEvent.VK_5:
                                button5.doClick();
                                break;
                            case KeyEvent.VK_6:
                                button6.doClick();
                                break;
                            case KeyEvent.VK_7:
                                button7.doClick();
                                break;
                            case KeyEvent.VK_8:
                                button8.doClick();
                                break;
                            case KeyEvent.VK_9:
                                button9.doClick();
                                break;
                            case KeyEvent.VK_0:
                                button10.doClick();
                                break;
                        }
                    }
                };

                button1.addKeyListener(listener2);
                add(statusLabel[2]);
                this.addKeyListener(listener2);
            }
        }

        class Execute3 extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Execute3 () {
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
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button3 will perform next actions
                        if(ae.getSource() == button3)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button4 will perform next actions
                        if(ae.getSource() == button4)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Exec\\");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
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

        class Dumps4 extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Dumps4 () {
                final JButton button1 = new JButton("GelLastAutoDump [1]");

                button1.setFont(font);
                button1.setVisible(true);
                button1.setToolTipText("Select last autodump Copy to desktop Compress to *.zip Create %Username%* on FTP Copy *.zip to FTP Open Username folder");
                button1.setSize(313, 110);
                add(button1);

                final JButton button2 = new JButton("GetLastManualDump [2]");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setToolTipText("Select last MANUALLY CREATED Dump and Copy to desktop Compress to *.zip Create %Username%* on FTP Copy *.zip to FTP Open Username folder");
                button2.setSize(313, 110);
                add(button2);

                final JButton button3 = new JButton("GetLastMemoryDump [3]");
                button3.setFont(font);
                button3.setVisible(true);
                button3.setToolTipText("Copy to desktop and FTP MEMORY Dump after BSOD or other issues");
                button3.setSize(313, 110);
                add(button3);

                final JButton button4 = new JButton("OpenTaskManager [4]");
                button4.setFont(font);
                button4.setVisible(true);
                button4.setToolTipText("Open SysWOW64 task manager for Manual Dump creation");
                button4.setSize(313, 110);
                add(button4);

                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetLastCUEDumpZIP.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetManualCUEDumpZIP.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button3
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button3)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\GetMemoryDump.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button4
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button4)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Dumps\\OpenTaskManager.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add KeyListener for Buttons press emulation by pressing Num1 button
                KeyListener listener4 = new KeyAdapter() {
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

                button1.addKeyListener(listener4);
                add(statusLabel[4]);
                this.addKeyListener(listener4);

            }
        }

        class Installation5 extends JPanel{

            //Adding method for reset timer with new value
            // after buttons below have been pressed
            public void timeReset(int seconds) {
                timer.stop();             //Stopping previous timer before execution of current script
                tm.setCountdown(seconds); //Setting time of  Script execution
                timer.start();            //Starting timer after script initiation
            }

            Installation5 () {
                final JButton button1 = new JButton("GetInstallLog [1]");

                button1.setFont(font);
                button1.setVisible(true);
                button1.setToolTipText("Copy setuoapi.dev.log to Desktop");
                button1.setSize(313, 110);
                add(button1);

                final JButton button2 = new JButton("GetOEMFiles [2]");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setToolTipText("Copy  OEM files to Desktop");
                button2.setSize(313, 110);
                add(button2);

                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Installation\\GetInstallLog.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add ActionListeners of Button2
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Installation\\GetOEMFiles.bat");
                                timeReset(2); //Set time of Script Execution Here
                            }
                            catch (Exception r){}
                        }
                    }
                });

                //Add KeyListener for Button1 press emulation by pressing Num1 button
                KeyListener listener5 = new KeyAdapter() {
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

                button1.addKeyListener(listener5);
                add(statusLabel[5]);
                this.addKeyListener(listener5);

            }
        }

        tabbedPane.addTab("Template",new Template(){
        });


        tabbedPane.addTab("AppData&Logs",new AppDataLogs1(){
        });

        tabbedPane.addTab("Links",new Link2() { //REFACTOR COMPONENT TO NESTED CLASS LINKS
        });

        tabbedPane.addTab("Execute",new Execute3(){
        });

        tabbedPane.addTab("Dumps",new Dumps4(){
        });

        tabbedPane.addTab("Installation",new Installation5(){
        });

        setPreferredSize(new Dimension(485, 215));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(tabbedPane);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(true);
                 new TestFrame();
            }
        });

        try {
            Robot robot = new Robot();
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        catch (Exception r) {}


    }





}
