package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksInstallation {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    GET_INSTALL_LOG(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/installation/GetInstallLog.bat")
                    .getAbsolutePath()),
    GET_OEM_FILES(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/installation/GetOEMFiles.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksInstallation(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
