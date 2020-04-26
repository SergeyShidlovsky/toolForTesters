package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksExecute {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    OPEN_APPLICATION_WIZARD(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/AppWiz.bat")
                    .getAbsolutePath()),
    OPEN_AUDIO_SETTINGS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenAudio.bat")
                    .getAbsolutePath()),
    OPEN_DEVICE_MANAGER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenDevMngr.bat")
                    .getAbsolutePath()),
    OPEN_DEVICE_AND_PRINTERS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenDeviceAndPrinters.bat")
                    .getAbsolutePath()),
    OPEN_DEVICE_METADATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenDeviceMetadata.bat")
                    .getAbsolutePath()),
    OPEN_DPR_CONNECTION(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenRDP.bat")
                    .getAbsolutePath()),
    OPEN_TASK_MANAGER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenTaskManager.bat")
                    .getAbsolutePath()),
    OPEN_UPDATE_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/execute/OpenUpdateServer.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksExecute(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}