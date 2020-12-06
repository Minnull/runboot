package com.run.boot;

import com.run.boot.exception.RunbootException;

import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2020/11/29 22:43
 * @Description:启动命令
 */
public interface RunBootCommand {

    /**
     * 运行入口
     * @param params
     * @throws RunbootException
     */
    void run(Map<String, String> params) throws RunbootException;

    /**
     * 获取启动命令
     *
     * @return
     */
    String runBootCommand();
}
