package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinkRegistry {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    OPEN_REGISTRY_EDITOR(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/OpenRegistryEditor.bat")
                    .getAbsolutePath()),
    OPEN_REGISTRY_EDITOR_CLINK_PIDS(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/OpenRegistryEditorClinkPIDs.bat")
                    .getAbsolutePath()),
    OPEN_REGISTRY_EDITOR_ERROR_REPORTING(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/registry/OpenRegistryEditorErrorReporting.bat")
                    .getAbsolutePath());

    private final String value;

    private LinkRegistry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
