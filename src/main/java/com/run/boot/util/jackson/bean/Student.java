package com.run.boot.util.jackson.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Auther: Administrator
 * @Date: 2019/8/18 19:24
 * @Description:
 */
public class Student {

    private String name;

    private Integer gradeNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeNum=" + gradeNum +
                '}';
    }
}
