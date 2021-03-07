package com.run.boot.demo.util.ReaderFileLineTest;

import com.run.boot.statics.GlobalDefaultPaths;
import com.run.boot.util.ReaderFileLine;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReaderFileLineTest {

    private static String PATH = GlobalDefaultPaths.testPackageHelpPath + "common/ReaderFileLineTest/cd.txt";

    @Test
    void getFileContent() {
        //注意文件的路径   反义斜杠
        //如果从外部读取txt文件内容需要注意：
        // 1.文件内看不见的空格  一般是开头第一个，删除不掉
        // 2.读取内容暂时别用java8 stream可能IO会报错
        List<String> s= ReaderFileLine.getFileContent(PATH);
        for (String s1 : s) {
            System.out.println(s1.trim());
        }

    }
}