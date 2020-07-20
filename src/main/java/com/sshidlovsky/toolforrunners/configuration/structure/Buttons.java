package com.sshidlovsky.toolforrunners.configuration.structure;

import lombok.Data;

@Data
public class Buttons {
    private String name;
    private String tooltip;
    private String scriptLink;
    private Integer scriptTimeExecution;
    private boolean showTerminalWindow;
}
