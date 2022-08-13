# runboot  
**项目简介**：  
     1.  学习、分享和保存常用工具类，代码本身是最好的文档。  
     2.  简单、轻量，按照程序启动时的输入命令，执行一遍程序后停止运行。

## 启动方式  
1.项目运行：java -jar runboot.jar 参数1  参数2 .......

## 使用步骤  
1.在包```com/run/boot/service/impl```下新建类，继承相关AbstractBaseService类，实现父类方法。  
参考：```com/run/boot/service/impl/RunServiceImpl.java```，实现以下方法：  
getCommand：设置启动命令  
run：开发业务逻辑  
2.在run方法里开发业务逻辑，代码执行的输入和输出内容，可以分别放置在```com/run/boot/service/input```和```com/run/boot/service/output```  
3.配置运行命令组，参考：src/main/resources/application.yml  
首先起个命令组名：如下first、two，然后把getCommand里的名称放置到命令组下，如 -run
```
runboot:
    commands:
        all:
            - run
            - two
        first:
            - run
            - two
        two:
            - two
            - run
```
4.启动时指定命令组，运行jar：java -jar runboot.jar first two .......  

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
  1.所有pr只需要关注com/run/boot/service下的三个目录和resuorces的一个yaml配置  
  imp：新建类  
  input：业务逻辑需要输入的数据存放位置
  output：业务逻辑需要产出的数据位置，允许随意删除 
  application.yml: 在runboot.commands.all默认命令组下配置新增的命令  

