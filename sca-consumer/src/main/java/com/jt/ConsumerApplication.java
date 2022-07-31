package com.jt;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {
    /*
    * Spring Web模块提供了一个RestTemplate对象，基于此对象可以
    * 完成远程服务的调用，在当前项目(服务)中，我们要使用这个对象，调用
    * 远程服务，但spring默认启动时，并没有创建这个对象，所以需要自己创建并交给
    * spring管理*/
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
