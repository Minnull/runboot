package com.run.boot.service.input.EasyExcelUtil;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author : maweijie
 * @date : 2019/1/30
 * @description:
 */
public class UserExcel extends BaseRowModel {

    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    @ExcelProperty(value = "name",index = 1)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+this.id+"  "+this.name+"]";
    }
}
