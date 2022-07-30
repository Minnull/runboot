package com.run.boot.service;

public abstract class AbstractBaseService {

    /**
     * 命名执行命令
     *
     * @return
     */
    public abstract String getCommand();

    /**
     * 运行代码
     */
    public abstract void run();
}
