package com.run.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//为了方便展示，去掉数据库，可以自己加上
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class RunbootApplication{

    //在cmd启动方式，与jar同一文件夹
    //使用命令：java -jar runboot-0.0.1-SNAPSHOT.jar 参数1  参数2  ...
    //前面是启动命令。后面是参数,这个参数在任何一个CommandLineRunner的run方法内都可以获取到
    public static void main(String[] args) {
        SpringApplication.run(RunbootApplication.class, args);
    }
}
