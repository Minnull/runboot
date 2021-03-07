# runboot  
**项目简介**：    
     1.  交流工具类， 可以快速学习、保存、使用工具类。  
     2.  支持springboot单次运行，单次运行方便、简单。  

## springboot单次启动  
使用springboot提供的CommandLineRunner接口，在命令行窗口传入命令，执行单次运行操作。

## 启动方式  
1.项目运行：java -jar runboot.jar 参数1  参数2 .......  

## 停止方式  
可以在项目增加exit退出，也可以ctrl+c退出。  

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

## 使用指南  
1.src/resources/runboot.sql初始化到数据库。  
2.src/main/java/com/run/boot/util/ 找到需要的工具类。  
3.src/test/java/com/run/boot/util/ 找到对应的demo类。  
4.根据demo类提示修改参数，运行。  
5.src/test/java/com/run/boot/help/ 找到demo类相关的文件。  
6.查看工具类效果。  

## 项目规范  
   1.  pr应该存在工具类和demo类，如果没有，应该加上todo备忘。  
   2.  demo类必须是可以运行的。  
   3.  demo类内需要加上注释，解释是做什么的，针对哪个工具类。   
   4.  demo类一切会变的输入变量，必须提到最上面设置为static变量。  
   5.  文件的主目录以GlobalDefaultPaths类为准。  
   6.  工具类位置：src/main/java/com/run/boot/util/，
       demo类位置：src/test/java/com/run/boot/util/，
       demo资源类位置：src/test/java/com/run/boot/help/，
       sql文件合并替换src/resources/runboot.sql  
   7.  工具类，demo类，demo资源类下面结构一致，以工具类为准。  
   8.  demo目录类把相同功能的类放一起，方便查找。  
   9.  单个java文件放到src/main/java/com/run/boot/util/common/包下面，
       整个jar的工具类，在src/main/java/com/run/boot/util/下面以jar名建立包，用来记录。  
   10. demo类名称是工具类名称末尾加上Test，
       demo资源类的package包是demo类名，以驼峰命名不变，方便查找，
       sql表名是根据工具类位置，比如util_common_jdbcutils_user,字段全部小写。  
  
  

