package com.run.boot.conf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Configuration
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "runboot")
public class RunCommandConfig {

    private Map<String, List<String>> commands;

    public Map<String, List<String>> getCommands() {
        return commands;
    }

    public void setCommands(Map<String, List<String>> commands) {
        this.commands = commands;
    }
}
