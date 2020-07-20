package com.sshidlovsky.toolforrunners.configuration;

import com.sshidlovsky.toolforrunners.configuration.structure.ToolForRunnersConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class ConfigurationLoader {
    private static final String FILENAME_PREFIX = "application";

    private static ToolForRunnersConfiguration getPropertiesFrom(String environment) {
        String filename = FILENAME_PREFIX + "-" + environment + ".yml";
        Yaml yaml = new Yaml();
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);

        return yaml.loadAs(in, ToolForRunnersConfiguration.class);
    }

    public static ToolForRunnersConfiguration getConfigurations(String environment) {

        return getPropertiesFrom(environment);
    }
}
