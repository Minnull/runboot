package com.run.boot.service.impl;

import com.run.boot.service.AbstractBaseService;
import com.run.boot.service.BaseService;
import org.springframework.stereotype.Component;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Component
public class TwoServiceImpl extends AbstractBaseService implements BaseService {

    @Override
    public String getCommand() {
        return "two";
    }

    @Override
    public void run() {
        System.out.println("two");
    }
}