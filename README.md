# runboot  
**项目简介**：  
     1.  快速交流工具类用法。  
     2.  CommandLineRunner是springboot提供的接口，可以在命令行窗口传入命令，
在程序启动后执行一次：即如同脚本运行一次可以完成自己想要的操作。    
**优点**：   
     1.  学习、分享和保存常用工具类，代码本身是最好的文档。  
     2.  速度快：快速定位已经用过的工具类，专注逻辑开发。  

## 启动方式  
1.项目运行：java -jar runboot.jar 参数1  参数2 .......

## 使用步骤  
1.在com/run/boot/service/impl新建运行类，参考：com/run/boot/service/impl/RunServiceImpl.java，继承相关AbstractBaseService类，实现父类方法
2.运行逻辑的输入和输出内容，可以分别放置在com/run/boot/service/input和com/run/boot/service/outputx
3.配置运行命令组，参考：src/main/resources/application.yml  
```
runboot:
    commands:
        first:
            - run
            - two
        two:
            - two
            - run
```
4.运行jar：java -jar runboot.jar first two .......  

## 项目结构
```
├── docker
├── logs
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── run
    │   │           └── boot
    │   │               ├── advice         ----全局异常拦截处理 
    │   │               ├── conf
    │   │               ├── enums          ----枚举类 
    │   │               ├── exception      ----错误码
    │   │               ├── result         ----返回格式
    │   │               ├── service        ----存业务逻辑,写一些自己的业务  
    │   │               │   ├── impl
    │   │               │   ├── input
    │   │               │   └── output
    │   │               ├── statics        ----静态变量
    │   │               └── util           ----工具类
```

## 项目规范  
  1.所有pr只需要关注com/run/boot/service下都三个目录
  imp：开发逻辑
  input：开发时用到的数据存放位置
  output：运行逻辑后需要输出的文件，这里保证可以任意删除

