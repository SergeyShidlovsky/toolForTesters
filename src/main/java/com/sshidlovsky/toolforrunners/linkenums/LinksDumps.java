package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksDumps {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    DO_NOT_ATTACH_GET_LAST_CUE_DUMP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/dumps/DoNotAttachGetLastCUEDump.bat")
                    .getAbsolutePath()),
    GET_LAST_CUE_DUMP_ZIP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/dumps//GetLastCUEDumpZIP.bat")
                    .getAbsolutePath()),
    GET_MANUAL_CUE_DUMP_ZIP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/dumps/GetManualCUEDumpZIP.bat")
                    .getAbsolutePath()),
    GET_MEMORY_DUMP(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/dumps/GetMemoryDump.bat")
                    .getAbsolutePath()),
    OPEN_DUMP_FOLDER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/dumps/OpenDumpFolder.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksDumps(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
