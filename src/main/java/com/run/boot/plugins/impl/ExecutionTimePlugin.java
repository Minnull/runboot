package com.run.boot.plugins.impl;

import com.run.boot.plugins.Invocation;
import com.run.boot.plugins.PluginsInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutionTimePlugin implements PluginsInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutionTimePlugin.class);

    @Override
    public Object proxy(Invocation invocation) throws Exception {
        long start = System.currentTimeMillis();
        LOGGER.info("ExecutionTimePlugin execution start time={}", start);
        Object process = invocation.process();
        long end = System.currentTimeMillis();
        LOGGER.info("ExecutionTimePlugin execution end time={},cost time={}", end, end - start);
        return process;
    }
}
