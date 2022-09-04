package com.run.boot.service;

import com.run.boot.plugins.PluginsInterceptor;
import com.run.boot.plugins.impl.ExecutionTimePlugin;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractBaseService {

    /**
     * 设置任务插件
     *
     * @return
     */
    public List<PluginsInterceptor> configPlugins() {
        List<PluginsInterceptor> interceptorList = new LinkedList<>();
        interceptorList.add(new ExecutionTimePlugin());
        return interceptorList;
    }
}
