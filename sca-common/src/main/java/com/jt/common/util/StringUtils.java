package com.jt.common.util;
/*
* 1.创建01-sca工程的子工程sca-common
* 2.在sac-common模块工程中创建一个工具类 判断一个字符串是否为空的静态方法
* 3.在sca-provider工程中添加一个springboot启动类 类名为com.jt.ProviderApplication
* 4.将sca-common工程以依赖的方式添加到sca-provider工程中
* 5.在sca-provider工程中写一个单元测试类，类全名为com.jt.util.StringTests,
* 在这个单元测试类中使用sca-common工程中写的StringUtils类，测试一个字符串是否为空*/
public class StringUtils {
    public static  boolean isEmpty(String str){
        return str==null||"".equals(str);
    }
}
