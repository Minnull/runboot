package com.run.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2020/12/5 19:26
 * @Description:
 */
@Component
@Configuration
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "runboot")
public class StartCommandConfig {

    private Map<String, List<String>> command;

    public Map<String, List<String>> getCommand() {
        return command;
    }

    public void setCommand(Map<String, List<String>> command) {
        this.command = command;
    }
}




