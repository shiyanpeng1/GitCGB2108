package com.jt.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Value("${spring.application.name:8080}")
    private String appName;
    /*
    * 借助此对象，可以基于服务名从nacos获取多个服务实例
    * 并且基于一定的负载均衡算法进行远端服务调用*/
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/doRestEcho1")
    public String doRestEcho01(){
        //基于服务名获取服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("sca-provider");
        //基于服务实例构建要访问的服务的url
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        //基于String类的format方法进行字符串拼接 %s表示占位符
        /*String url = String.format
                ("http://%s:%s/provider/echo/%s",ip,port,appName);
        return restTemplate.getForObject(url,String.class);*/
        String url = String.format
                ("http://%s:%s/provider/echo/{msg}",ip,port);
        return restTemplate.getForObject(url,String.class,appName);
    }
    @Autowired
    private RestTemplate loadBalancedRestTemplate;
    @GetMapping("/consumer/doRestEcho2")
    public String doRestEcho02(){
        String serverName = "sca-provider";
        String url = String.format
                ("http://%s/provider/echo/{msg}",serverName);
        return loadBalancedRestTemplate.getForObject(url,String.class,appName);
    }

}
