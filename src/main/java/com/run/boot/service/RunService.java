package com.run.boot.service;

import com.run.boot.AbstractRunBootService;
import com.run.boot.RunBootCommand;
import com.run.boot.config.StartCommandConfig;
import com.run.boot.exception.RunbootException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Component
public class RunService extends AbstractRunBootService implements RunBootCommand {

    @Autowired
    private StartCommandConfig startCommandConfig;

    @Override
    public void run(Map<String, String> params) throws RunbootException {
        //用主类启动报莫名其妙错的话，自己启动一个线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("输出副线程");
                System.out.println(startCommandConfig.getCommand());
            }

        }.start();
    }

    @Override
    public String runBootCommand() {
        return "run";
    }
}
