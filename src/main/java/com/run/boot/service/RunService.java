package com.run.boot.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : null
 * @date : 2018/10/17
 * @description:
 */
@Component
@Order(value = 1)
public class RunService implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("输出从外部传入的参数"+args[0]+"第二个："+args[1]);
        //用主类启动报莫名其妙错的话，自己启动一个线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("输出副线程");
            }

        }.start();
    }
}
