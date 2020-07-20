package com.sshidlovsky.toolforrunners.configuration.structure;

import lombok.Data;

import java.util.List;

@Data
public class ToolForRunnersConfiguration {
    private String quantityOfTabs;
    private List<Tabs> tabsList;
}
