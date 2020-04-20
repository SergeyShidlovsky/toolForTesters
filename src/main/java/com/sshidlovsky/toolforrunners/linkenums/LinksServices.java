package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksServices {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    OPEN_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/services/OpenServices.bat")
                    .getAbsolutePath()),
    START_AUDIO_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/services/StartAudioService.bat")
                    .getAbsolutePath()),
    START_INTEGRATION_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/services/StartIntegrationService.bat")
                    .getAbsolutePath()),
    STOP_AUDIO_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/services/StopAudioService.bat")
                    .getAbsolutePath()),
    STOP_INTEGRATION_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/services/StopIntegrationService.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksServices(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}