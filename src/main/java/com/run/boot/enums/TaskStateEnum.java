package com.run.boot.enums;

/**
 * @Auther: Administrator
 * @Date: 2020/9/15 23:31
 * @Description:
 */
public enum TaskStateEnum {

    FAIL(-1, "失败"),
    SUCCESS(0, "成功");

    /**
     * 任务状态
     */
    private Integer state;
    /**
     * 任务状态含义
     */
    private String desc;

    TaskStateEnum(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
