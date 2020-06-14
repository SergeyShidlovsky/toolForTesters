package com.sshidlovsky.toolforrunners.configuration.structure;

import lombok.Data;

import java.util.List;

@Data
public class Tabs {
    private String name;
    private Integer quantitiesOfButtons;
    private List<Buttons> buttonsList;
}
