package com.run.boot.service.impl;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.run.boot.statics.GlobalDefaultPaths;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author : maweijie
 * @date : 2019/3/28
 * @description:项目地址：https://github.com/bazaarvoice/jolt
 */
//todo 还报错 需要修改
public class Jolt {

    private static String path = GlobalDefaultPaths.runOutPutPath + "common/JoltTest/";

    private static String specPath = path + "spec.json";

    private static String inputPath = path + "input.json";

    public void TransformTest() throws FileNotFoundException {
        List chainrSpecJSON = JsonUtils.classpathToList(specPath);
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

        Object inputJSON = JsonUtils.classpathToObject(inputPath);

        Object transformedOutput = chainr.transform(inputJSON);
        System.out.println(JsonUtils.toJsonString(transformedOutput));
    }
}
