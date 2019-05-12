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
@Order(value = 2)//这是启动这个类的顺序
public class TwoService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("输出从外部传入的参数"+args[0]+"第二个："+args[1]);
        //用主类启动报莫名其妙错的话，自己启动一个线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("输出第二个副线程");
                //interrupt();//这个放到最后一个线程执行完毕后，自动结束，不用手动ctrl+c结束
            }
        }.start();
    }
}