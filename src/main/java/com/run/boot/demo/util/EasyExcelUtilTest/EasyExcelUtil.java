package com.run.boot.demo.util.EasyExcelUtilTest;

import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Lists;
import com.run.boot.demo.util.EasyExcelUtilTest.UserExcel;
import com.run.boot.statics.GlobalDefaultPaths;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : maweijie
 * @date : 2019/1/30
 * @description:
 */
public class EasyExcelUtil {

    private static String path = GlobalDefaultPaths.testPackageHelpPath + "common/EasyExcelUtil/";

    //生成excel路径
    private static String exportPath = path + "study.xls";

    //读取excel路径
    private static String readPath = path + "study.xls";

    public static void main(String[] args) {
    }

    public void readExcelWithStringList() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(readPath);
        List<List<String>> lists = com.run.boot.util.EasyExcelUtil.readExcelWithStringList(inputStream, ExcelTypeEnum.XLS);
        for (List<String> list : lists) {
            System.out.printf(list.toString());
        }
    }

    public void writeExcelWithStringList() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(exportPath);
        //这里是sheet
        Table table = new Table(0);
        List<List<String>> data = new ArrayList<>();
        List<String> dataIn1 = Lists.newArrayList("测试一", "测试二");
        List<String> dataIn2 = Lists.newArrayList("学习一", "学习二");
        data.add(dataIn1);
        data.add(dataIn2);
        com.run.boot.util.EasyExcelUtil.writeExcelWithStringList(outputStream, data, table, ExcelTypeEnum.XLS);
    }

    public void exportExcel() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(exportPath);
        Table table = new Table(0);
        List<UserExcel> list = new ArrayList<>();
        UserExcel userExcel = new UserExcel();
        userExcel.setName("测试3");
        userExcel.setId(1);
        list.add(userExcel);
        com.run.boot.util.EasyExcelUtil.writeExcelWithModel(outputStream, list, table, UserExcel.class, ExcelTypeEnum.XLS);
    }

    public void readExcel() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(readPath);
        List<Object> objects = com.run.boot.util.EasyExcelUtil.readExcelWithModel(inputStream, UserExcel.class, ExcelTypeEnum.XLS);
        for (Object object : objects) {
            System.out.println(object.toString());
        }
    }
}
