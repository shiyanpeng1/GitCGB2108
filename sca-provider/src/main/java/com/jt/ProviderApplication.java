package com.jt;


import com.jt.provider.controller.TimeHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ProviderApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
/*
* 定义spring web mvc 配置，需要实现spring中的WebMvcConfigurer接口
* 注册拦截器(添加到spring容器) 并指定拦截规则*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeHandlerInterceptor())
                .addPathPatterns("/provider/sentinel01");
    }
}
