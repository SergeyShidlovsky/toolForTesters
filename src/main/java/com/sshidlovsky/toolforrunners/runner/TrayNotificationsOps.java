package com.sshidlovsky.toolforrunners.runner;

import java.awt.*;

@SuppressWarnings("ALL")
public class TrayNotificationsOps {

    private Image image;
    private SystemTray tray;
    private TrayIcon trayIcon;

    public TrayNotificationsOps() throws AWTException {
        tray = SystemTray.getSystemTray();
        image = Toolkit.getDefaultToolkit().createImage("icon.png");
        trayIcon = new TrayIcon(image, "Tray Demo");

        //Initiate tray notificztion elements
        configureTrayElements();
    }

    public void displayInfoTrayMessage(String caption, String description) {
        //ToDo add support of macOs desktop notifications
        if (SystemTray.isSupported()){
            trayIcon.displayMessage(caption, description, TrayIcon.MessageType.INFO);
        } else {
            //Todo Replace with log4j
            System.out.println( "Windowns info tray notifications are not supported");
        }
    }

    public void displayWarningTrayMessage(String caption, String description) {
        if (SystemTray.isSupported()){
            trayIcon.displayMessage(caption, description, TrayIcon.MessageType.WARNING);
        } else {
            //Todo Replace with log4j
            System.out.println( "Windowns warning tray notifications are not supported");
        }
    }

    public void displayErrorTrayMessage(String caption, String description) {
        if (SystemTray.isSupported()){
            trayIcon.displayMessage(caption, description, TrayIcon.MessageType.ERROR);
        } else {
            //Todo Replace with log4j
            System.out.println( "Windowns error tray notifications are not supported");
        }
    }

    public void displaySimpleTrayMessage(String caption, String description) {
        if (SystemTray.isSupported()){
            trayIcon.displayMessage(caption, description, TrayIcon.MessageType.NONE);
        } else {
            //Todo Replace with log4j
            System.out.println( "Windowns info tray notifications are not supported");
        }
    }

    private void configureTrayElements() throws AWTException {
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
    }

    //ToDo remove this method after desktop notifcations will be integrated
    public static void main(String[] args) throws AWTException {
            TrayNotificationsOps td = new TrayNotificationsOps();
            td.displaySimpleTrayMessage("Caption", "Simple");
            td.displayInfoTrayMessage("Caption", "Info");
            td.displayWarningTrayMessage("Warning", "Warning");
            td.displayErrorTrayMessage(System.getenv().get("OS"), "Error");
    }
}
