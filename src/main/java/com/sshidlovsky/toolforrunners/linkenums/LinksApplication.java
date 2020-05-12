package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksApplication {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/" +
                    "RestartWithClearedAppdataProgramdataRestrtService.bat")
                    .getAbsolutePath()),
    RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/" +
                    "RestartWithClearedAppdataProgramdataRestrtServiceWithBackUp.bat")
                    .getAbsolutePath()),
    RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/" +
                    "RestartWithDebugLoggingAndClearedAppdataProgramdataRestrtService.bat")
                    .getAbsolutePath()),
    RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/" +
                    "RestartWithDebugLoggingAndClearedAppdataProgramdataRestrtServiceWithBackUp.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksApplication(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
