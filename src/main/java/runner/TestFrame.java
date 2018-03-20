package runner;
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

        super("Тестовое окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Font font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        class Exec1 extends JPanel{
            Exec1 () {

                // MyKey listener = new MyKey();
                // addKeyListener(listener);
                setFocusable(true);

                //Configure visual settings of Button1
                final JButton button1 = new JButton("Open Appdata [1]");
                button1.setFont(font);
                button1.setVisible(true);
                button1.setToolTipText("Opens %Appata% folder");
                button1.setSize(313, 110);
                add(button1);

                //Configure visual setting of Button2
                final JButton button2 = new JButton("Open logs [2]");
                button2.setFont(font);
                button2.setVisible(true);
                button1.setToolTipText("Opens CUE Log folder");
                button2.setSize(313, 110);
                add(button2);

                //Configure visual settings of Button3
                final JButton button3 = new JButton("Clear Appdata [3]");
                button1.setFont(font);
                button1.setVisible(true);
                button1.setToolTipText("Delete CUE %Appata% folder");
                button1.setSize(313, 110);
                add(button3);

                //Configure visual setting of Button4
                final JButton button4 = new JButton("Clear logs [4]");
                button2.setFont(font);
                button2.setVisible(true);
                button1.setToolTipText("Delete CUE Log folder");
                button2.setSize(313, 110);
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
                                Runtime.getRuntime().exec("notepad.exe");
                            }
                            catch (Exception r){}
                        }
                        // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
                    }
                });

                //Add KeyListener for Button1 press emulation by pressing Num1 button
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

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions
                        if(ae.getSource() == button2)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\Users\\Sergey\\Desktop\\exr.bat");
                            }
                            catch (Exception r){}
                        }
                    }
                });



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
                final JButton button1 = new JButton("Open Squash");

                button1.setFont(font);
                button1.setVisible(true);
                button1.setSize(313, 110);
                add(button1);

                JButton button2 = new JButton("Open Appdata");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setSize(313, 110);
                add(button2);

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        if(ae.getSource() == button1)
                        {
                            try
                            {
                                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe https://git.devx.dp.ua");
                                //    Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe  https://git.devx.dp.ua");
                                //     Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe"  );
                                //     System.out.print("start C:\\Users\\Sergey\\Desktop\\sys");
                            }
                            catch (Exception r){}
                        }
                        // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
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

                        }
                    }
                };

                button1.addKeyListener(listener2);

                this.addKeyListener(listener2);

            }

        }

        tabbedPane.addTab("*.bat exec",new Exec1(){
        });

        tabbedPane.addTab("Links",new Link2() { //REFACTOR COMPONENT TO NESTED CLASS LINKS
        });

        tabbedPane.addTab("Articles",new Component(){

        });

        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
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
    }



}
