package com.jt.provider.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

/*
* 定义一个基于时间进行访问控制的拦截器，规范是springmvc中的HandlerInterceptor，
* 写好拦截器后，这这个拦截器要对哪些请求进行拦截还要进行配置*/
@Component
public class TimeHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("====preHandle=====");
        //1.获取当前时间
        LocalTime now = LocalTime.now();//没有年月日 LocalTime为jdk8中的一个获取当前时间的api
        //2.获取当前的小时
        int hour = now.getHour();
        System.out.println("hour="+hour);
        if(hour<9||hour>18){
            throw new RuntimeException("请在9-18点访问");//相当于return false 还可以给出提示
        }
        return true;//true表示放行，会去执行后续的拦截器后控制层业务
    }

}
