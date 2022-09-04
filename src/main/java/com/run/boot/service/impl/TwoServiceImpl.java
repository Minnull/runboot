package com.run.boot.service.impl;

import com.run.boot.service.AbstractBaseService;
import com.run.boot.service.IBaseService;
import org.springframework.stereotype.Service;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Service
public class TwoServiceImpl extends AbstractBaseService implements IBaseService {

    @Override
    public String getCommand() {
        return "two";
    }

    @Override
    public void run() {
        System.out.println("two");
    }
}