package com.run.boot.service.impl;

import com.run.boot.plugins.PluginsInterceptor;
import com.run.boot.plugins.impl.ExecutionTimePlugin;
import com.run.boot.service.AbstractBaseService;
import com.run.boot.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ThreeServiceImpl extends AbstractBaseService implements IBaseService {

    @Override
    public List<PluginsInterceptor> configPlugins() {
        List<PluginsInterceptor> interceptorList = new LinkedList<>();
        interceptorList.add(new ExecutionTimePlugin());
        interceptorList.add(new ExecutionTimePlugin());
        interceptorList.add(new ExecutionTimePlugin());
        return interceptorList;
    }

    @Override
    public String getCommand() {
        return "three";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run three service");
    }
}
