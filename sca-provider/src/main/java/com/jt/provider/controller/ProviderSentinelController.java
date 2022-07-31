package com.jt.provider.controller;

import com.jt.provider.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/provider")
public class ProviderSentinelController {
    //拓展练习：要求对此方法访问按时间进行限制
    //解决方法：基于springmvc中的拦截器进行实现
 @GetMapping("/sentinel01")
    public String doSentinel01(){
     return "sentinel 01 test..." ;
 }
 @GetMapping("/sentinel02")
    public String doSentinel02(){
        return "sentinel 02 test  ...";
    }
    @Autowired
    private ResourceService resourceService;
    @GetMapping("/sentinel03")
    public String doSentinel03(){
        return resourceService.doService();
      //  return "sentinel 03 test  ...";
    }
    @GetMapping("/sentinel04")
    public String doSentinel04(){
        resourceService.doService();
        return "sentinel 04 test  ...";
    }

    /*
    * 通过此方法演示服务降级
    * AtomicInteger 对象提供了一种线程安全(底层通过乐观锁保证)的自增和自减操作
    * */
    private AtomicInteger atomicInteger = new  AtomicInteger(1);
    @GetMapping("/sentinel05")
    public String doSentinel05() throws InterruptedException {
        int num = atomicInteger.getAndIncrement();
        if(num%2==0){
            Thread.sleep(300);//线程休眠 (模拟耗时操作)
            //num/=0;  //异常比例
        }
        return "sentinel 05 test  ...";
    }
    @GetMapping("/sentinel06")
    public String doFindById(@RequestParam("id") Integer id){//不加注解也ok
        return resourceService.doGetResource(id);
    }

}
