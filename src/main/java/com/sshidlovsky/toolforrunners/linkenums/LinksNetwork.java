package com.sshidlovsky.toolforrunners.linkenums;

import java.io.File;

public enum LinksNetwork {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    DISABLE_NETWORK_ADAPTER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/network/DisableNetworkAdapter.bat")
                    .getAbsolutePath()),
    ENABLE_NETWORK_ADAPTER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/network/EnableNetworkAdapter.bat")
                    .getAbsolutePath()),
    OPEN_NETWORK_ADAPTER(
            new File("src/main/java/com/sshidlovsky/toolforrunners/scripts/network/OpenNetworkAdapter.bat")
                    .getAbsolutePath());

    private final String value;

    private LinksNetwork(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
