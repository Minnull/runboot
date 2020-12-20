package com.run.boot.service;

import com.run.boot.AbstractRunBootService;
import com.run.boot.RunBootCommand;
import com.run.boot.exception.RunbootException;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Component
public class RunService extends AbstractRunBootService implements RunBootCommand {

    @Override
    public void run(Map<String, String> params) throws RunbootException {
        System.out.println("输出副线程");
    }

    @Override
    public String runBootCommand() {
        return "run";
    }
}
