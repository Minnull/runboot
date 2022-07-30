package com.run.boot;

import com.run.boot.conf.RunCommandConfig;
import com.run.boot.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class RunbootApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(RunbootApplication.class);

    @Autowired
    private RunCommandConfig runCommands;

    @Autowired
    private List<BaseService> baseServices;

    private Map<String, BaseService> baseServiceMap = new ConcurrentHashMap<>();

    private static final String runCommandExample = "java -jar runboot-0.0.1-SNAPSHOT.jar param1  param2  ...";

    @PostConstruct
    public void initBaseService() {
        baseServices.forEach(s ->
                baseServiceMap.put(s.getCommand(), s)
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(RunbootApplication.class, args);
        System.exit(0);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            LOG.warn("No startup command is entered,program exited.");
            return;
        }
        Map<String, List<String>> commands = runCommands.getCommands();
        if (commands.size() == 0) {
            LOG.warn("No runnable task was found,program exited.");
            return;
        }
        LOG.info("Start executing command.");
        for (int i = 0; i < args.length; i++) {
            List<String> innerCommands = commands.get(args[i]);
            LOG.info("Start executing group {} commands,command={},task list={}", i, args[i], innerCommands);
            if (innerCommands.size() == 0) {
                LOG.warn("This command does not create a task,skip command={}.", args[i]);
                continue;
            }
            for (String innerCommand : innerCommands) {
                LOG.debug("Start task {}", innerCommand);
                baseServiceMap.get(innerCommand).run();
                LOG.debug("End task {}", innerCommand);
            }
        }
    }
}
