package com.run.boot.plugins;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现插件封装
 */
public class PluginsInvocationHandler implements InvocationHandler {

    private Object target;

    private PluginsInterceptor interceptor;

    public PluginsInvocationHandler(Object target, PluginsInterceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target, method, args);
        return interceptor.proxy(invocation);
    }

    public static Object wrap(PluginsInvocationHandler targetProxy) {
        return Proxy.newProxyInstance(targetProxy.target.getClass().getClassLoader(), targetProxy.target.getClass().getInterfaces(), targetProxy);
    }
}
