package com.run.boot.service;

public interface BaseService {

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
