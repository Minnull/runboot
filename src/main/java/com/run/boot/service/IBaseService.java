package com.run.boot.service;

import com.run.boot.plugins.PluginsInterceptor;

import java.util.List;

public interface IBaseService {

    List<PluginsInterceptor> configPlugins();

    /**
     * 命名执行命令
     *
     * @return
     */
    String getCommand();

    /**
     * 运行代码
     */
    void run();
}
