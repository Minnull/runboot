package com.run.boot.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.run.boot.util.jackson.bean.Student;

/**
 * @Auther: Administrator
 * @Date: 2019/8/18 19:40
 * @Description:
 */
public class Json {

    void getBean2Json(){
        Student student = new Student();
        student.setGradeNum(2);
        student.setName("学习");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(student.toString());
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    void getJson2Bean(){
        ObjectMapper mapper = new ObjectMapper();
    }
}
