package com.run.boot.plugins;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 责任链模式初始化所有插件
 */
public class PluginsInterceptorChain {

    private List<PluginsInterceptor> interceptorList = new LinkedList<>();

    public Object initAllPlugins(Object target) {
        Object pre = null;
        if (CollectionUtils.isNotEmpty(interceptorList)) {
            for (PluginsInterceptor interceptor : interceptorList) {
                if (pre == null) {
                    pre = PluginsInvocationHandler.wrap(new PluginsInvocationHandler(target, interceptor));
                } else {
                    pre = PluginsInvocationHandler.wrap(new PluginsInvocationHandler(pre, interceptor));
                }
            }
        }
        return pre != null ? pre : target;
    }

    public PluginsInterceptorChain addPlugin(PluginsInterceptor interceptor) {
        interceptorList.add(interceptor);
        return this;
    }

    public PluginsInterceptorChain addPlugins(List<PluginsInterceptor> interceptor) {
        interceptorList = interceptor;
        return this;
    }

    public List<PluginsInterceptor> findPluginList() {
        return Collections.unmodifiableList(interceptorList);
    }
}