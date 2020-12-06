package com.run.boot.service;

import com.run.boot.AbstractRunBootService;
import com.run.boot.RunBootCommand;
import com.run.boot.config.StartCommandConfig;
import com.run.boot.exception.RunbootException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Component
public class TwoService extends AbstractRunBootService implements RunBootCommand {


    @Autowired
    private StartCommandConfig startCommandConfig;

    @Override
    public void run(Map<String, String> params) throws RunbootException {
        System.out.println("输出第二个副线程");
    }

    @Override
    public String runBootCommand() {
        return "two";
    }
}