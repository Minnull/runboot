package com.run.boot.statics;

/**
 * @Auther: Administrator
 * @Date: 2020/9/15 23:31
 * @Description:程序退出-全局状态码
 */
public class GlobalStatusCode {

    private static final ThreadLocal<Integer> currentState = new ThreadLocal<>();

    static {
        currentState.set(GlobalStatusCode.SUCCESS);
    }

    public static void setCurrentState(Integer state) {
        currentState.set(state);
    }

    public static Integer getCurrentState() {
        return currentState.get();
    }

    public static void clearCurrentState() {
        currentState.remove();
    }

    public static final Integer SUCCESS = 0;
    public static final Integer ERROR_EXIT = -1;
}
