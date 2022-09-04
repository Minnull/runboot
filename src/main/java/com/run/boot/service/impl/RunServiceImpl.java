package com.run.boot.service.impl;

import com.run.boot.plugins.PluginsInterceptor;
import com.run.boot.service.AbstractBaseService;
import com.run.boot.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Service
public class RunServiceImpl extends AbstractBaseService implements IBaseService {

    @Override
    public List<PluginsInterceptor> configPlugins() {
        return null;
    }

    @Override
    public String getCommand() {
        return "run";
    }

    @Override
    public void run() {
        System.out.println("run ...");
    }
}
