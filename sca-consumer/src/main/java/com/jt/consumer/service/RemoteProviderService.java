package com.jt.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/*
* 这里的@FeignClient注解用于描述Feign远程服务调用接口，假如在项目配置类或启动类上添加了
* @EnableFeignClients注解，系统会在启动时，扫描@FeignClient注解描述的接口，并在接口创建
* 实现类对象(这个实现类称之为代理对象),此对象内部会封装对远程服务调用的过程
* @FeignClient 注解中name属性的值有两个层面的含义：
* 1）RemoteProviderService接口类型对象交给spring管理时，这个对象(bean)的名字
* 2）远程调用的服务名*/
@FeignClient(name = "sca-provider" ,contextId = "remoteProviderService",fallbackFactory = RemoteProviderFallBackFactory.class)
public interface RemoteProviderService {//声明式接口(声明要调用的远程服务以及对应的资源)
    @GetMapping("/provider/echo/{msg}")
    public String echoMessage(@PathVariable("msg") String msg);
}
