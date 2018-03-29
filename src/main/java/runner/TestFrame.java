package toolForRunners;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */

//See changelog.txt for qny questions

public class TestFrame extends JFrame {
    static int i = 0;

    public TestFrame() {

        super("Tool For QA Engineers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Font font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        //добавить лейбел .который будет показывать время выполненния скрипта
        //и будет прятаться после того, как таймер пройдет

        class Template extends JPanel{
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

                //Adding Status Label that is running down time of scripts execution
                JLabel statusLabel = new JLabel("                      Wait time                        ");
                statusLabel.setFont(font);
                statusLabel.setVisible(true);
                statusLabel.setSize(313,110);
                statusLabel.setHorizontalAlignment(2);
                statusLabel.setLocation(200,200);
                add(statusLabel);



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
                                Runtime.getRuntime().exec("C:\\toolForRunners\\AppDataLogs\\OpenLogs.bat");
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
                        }
                    }
                };

                button1.addKeyListener(listener);

                this.addKeyListener(listener);

            }
        }

        class AppDataLogs1 extends JPanel{
            AppDataLogs1 () {

                // MyKey listener = new MyKey();
                // addKeyListener(listener);
                // setFocusable(true);

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
                                // Runtime.getRuntime().exec("C:\\Program Files (x86)\\Corsair\\Corsair Utility Engine\\CUE.exe");
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

                this.addKeyListener(listener);





            }
            //class MyKey implements KeyListener{
            //    public void keyPressed(KeyEvent event){
            //        if (event.getKeyCode() == KeyEvent.VK_ENTER){
            //            //обработка нажатия ENTER
            //           ;
            //        }
            //    }
            //   public void keyReleased(KeyEvent event){
            //   }
            //   public void keyTyped(KeyEvent event){

            //   }
            //}

        }

        class Link2 extends JPanel{

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
                                Runtime.getRuntime().exec("C:\\toolForRunners\\Links\\OpenBuilder.bat");
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

                this.addKeyListener(listener2);
            }
        }

        class Execute3 extends JPanel{

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

                this.addKeyListener(listener3);
            }
        }

        class Dumps4 extends JPanel{

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

                this.addKeyListener(listener4);

            }
        }

        class Installation5 extends JPanel{

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
