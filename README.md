# runboot  
**项目简介**：  
     1.  快速交流工具类用法。  
     2.  CommandLineRunner是springboot提供的接口，可以在命令行窗口传入命令，
在程序启动后执行一次：即如同脚本运行一次可以完成自己想要的操作。    
**优点**：   
     1.  学习，记录：工具类学习的地方，代码本身是最好的文档。  
     2.  轻量级：项目可以如同脚本执行单次操作，方便。  
     3.  复用：调用工具类快速完成相关功能，不重复造轮子。  

## 启动方式  
1.项目运行：java -jar runboot.jar 参数1  参数2 .......

## 使用步骤  
1.新建运行类，参考：com/run/boot/service/impl/RunServiceImpl.java，同级包内创建运行类，继承和实现相关base类  
2.配置运行命令组，参考：src/main/resources/application.yml  
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
3.maven编译打包，生成jar  
4.运行jar：java -jar runboot.jar first two .......  

## 项目结构  
**src/main/java/com/run/boot/**  
advice    ----全局异常拦截处理  
business  ----存业务逻辑,写一些自己的业务   
enums     ----枚举类  
exception ----错误码   
result    ----返回格式  
service   ----运行启动的service    
statics   ----静态变量  
util      ----工具类  
**src/resources/**  
sql       ----存放全局sql文件   
**src/test/java/com/run/boot/**   
contents  ----demo目录类    
help      ----demo资源类  
util      ----demo类

## 项目规范  
  1.todo  
