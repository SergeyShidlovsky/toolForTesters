package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksAppDataLogs {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    CLEAN_LOGS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "CleanLogs.bat")
                    .getAbsolutePath()),
    CLEAN_PROGRAMDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "CleanProgrammData.bat")
                    .getAbsolutePath()),
    CLEAR_APPDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "ClearAppData.bat")
                    .getAbsolutePath()),
    GET_ARCIVE_APPDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "GetArchiveAppdata.bat")
                    .getAbsolutePath()),
    GET_ARCHIVE_PROGRAMDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "GetArchiveProgramData.bat")
                    .getAbsolutePath()),
    GET_LAST_ARHIVED_PROGRAMDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "GetLastArchivedProgramAppData.bat")
                    .getAbsolutePath()),
    GET_LAST_LOG(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "GetLastLog.bat")
                    .getAbsolutePath()),
    OPEN_APPDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "OpenAppData.bat")
                    .getAbsolutePath()),
    OPEN_DEBUG_SERVICE_FOLDER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "OpenDebugServiceFolder.bat")
                    .getAbsolutePath()),
    OPEN_FOLDER_WITH_ARCHIVED_PROGRAM_APPDATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "OpenFolderWithArchivedPrgramAppData.bat")
                    .getAbsolutePath()),
    OPEN_LOGS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "OpenLogs.bat")
                    .getAbsolutePath()),
    OPEN_PROGRAM_DATA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/appdatalogs/" +
                    "OpenProgramData.bat")
                    .getAbsolutePath());

    //ToDo Use lombok setter and move valiable declaration to the top of enum
    private final String value;

    private LinksAppDataLogs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}