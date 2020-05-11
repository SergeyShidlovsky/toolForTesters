package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksLinks {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    FIRMWARE(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/Firmware.bat")
                    .getAbsolutePath()),
    BUILDER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenBuilder.bat")
                    .getAbsolutePath()),
    BUILDS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenBuilds.bat")
                    .getAbsolutePath()),
    DEVICE_INFO(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenDeviceDoc.bat")
                    .getAbsolutePath()),
    DOCUMENTATION_CUE_2_0(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenDocumentationCUE2.bat")
                    .getAbsolutePath()),
    DOCUMENTATION_CUE_3_0(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenDocumentationCUE3.bat")
                    .getAbsolutePath()),
    PHABRICATOR(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenGit.bat")
                    .getAbsolutePath()),
    PM_AREA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenPMArea.bat")
                    .getAbsolutePath()),
    REPORT(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenReport.bat")
                    .getAbsolutePath()),
    SQUASH(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenSquash.bat")
                    .getAbsolutePath()),
    TEST_MACHINES(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenTestMashines.bat")
                    .getAbsolutePath()),
    WIKI_QA(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/links/OpenWikiQA.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksLinks(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}