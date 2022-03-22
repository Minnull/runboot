package com.run.boot;

import com.run.boot.conf.RunCommandConfig;
import com.run.boot.service.BaseService;
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

    @Autowired
    private RunCommandConfig runCommands;

    @Autowired
    private List<BaseService> baseServices;

    private Map<String, BaseService> baseServiceMap = new ConcurrentHashMap<>();

    private static final String runCommandExample = "java -jar runboot-0.0.1-SNAPSHOT.jar 参数1  参数2  ...";

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
        //todo 执行命令校验
        Map<String, List<String>> commands = runCommands.getCommands();
        for (String innerKey : commands.keySet()) {
            List<String> innerCommands = commands.get(innerKey);
            for (String innerCommand : innerCommands) {
                baseServiceMap.get(innerCommand).run();
            }
        }
    }
}
