package com.run.boot;

import com.run.boot.config.StartCommandConfig;
import com.run.boot.statics.GlobalStatusCode;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class RunbootApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunbootApplication.class);

    @Autowired
    private List<RunBootCommand> runBootCommands;
    @Autowired
    private StartCommandConfig startCommandConfig;

    private Map<String, RunBootCommand> runBootCommandMap = new HashMap<>();

    private static String START_COMMAND_EXAMPLE = "Start command example：java -jar runboot-0.0.1-SNAPSHOT.jar 参数1  参数2  ...";

    @PostConstruct
    public void init() {
        runBootCommands.forEach(s -> {
            runBootCommandMap.put(s.runBootCommand(), s);
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(RunbootApplication.class, args);
        LOGGER.info("SpringApplication run finished.");
        if (null == GlobalStatusCode.getCurrentState()) {
            LOGGER.warn("RunbootApplication do not manually initialize the global status code.");
            GlobalStatusCode.setCurrentState(GlobalStatusCode.ERROR_EXIT);
        }
        System.exit(GlobalStatusCode.getCurrentState());
    }

    @Override
    public void run(String... args) {
        Map<String, List<String>> command = startCommandConfig.getCommand();
        LOGGER.info("SpringApplication run args.args={},allCommands={}", args, command);
        if (null == args || args.length < 1) {
            LOGGER.error("Can't find start command.Example command={}", START_COMMAND_EXAMPLE);
            System.exit(GlobalStatusCode.ERROR_EXIT);
            return;
        }
        if (null == command || command.isEmpty()) {
            LOGGER.error("There are no commands available in the system, please check yaml.");
            System.exit(GlobalStatusCode.ERROR_EXIT);
            return;
        }
        for (String arg : args) {
            LOGGER.info("Running command，args={}}", arg);
            List<String> usefulCommand = command.get(arg);
            if (CollectionUtils.isEmpty(usefulCommand)) {
                LOGGER.warn("The current command is not available.Example arg={}", arg);
                continue;
            }
            for (String useCommand : usefulCommand) {
                RunBootCommand runBootCommand = runBootCommandMap.get(useCommand);
                if (null == runBootCommand) {
                    LOGGER.error("Check command the object is not available. runBootCommand={}", runBootCommand);
                    System.exit(GlobalStatusCode.ERROR_EXIT);
                    return;
                }
            }
            for (String useCommand : usefulCommand) {
                runBootCommandMap.get(useCommand).run(new HashMap<>());
            }
        }
    }
}
