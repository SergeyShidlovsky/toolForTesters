package com.sshidlovsky.toolforrunners.configuration;

import com.sshidlovsky.toolforrunners.configuration.structure.ToolForRunnersConfiguration;
import lombok.Getter;

@Getter
public class ConfigurationStore {
    private ToolForRunnersConfiguration config;
    //ToDo Read here all configs from Yaml and initiate all varialbles in constructor

    public ConfigurationStore() {
        config = ConfigurationLoader.getConfigurations(System.getenv("environment"));
    }
}
