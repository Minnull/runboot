package com.run.boot.plugins;

public interface PluginsInterceptor {

    Object proxy(Invocation invocation) throws Exception;
}
