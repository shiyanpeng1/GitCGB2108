package com.jt.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    /*
    * @SentinelResource 描述方法时，可以在sentinel控制台创建一个资源链路
    * 这个资源链路的名称默认为value属性的值，当出现限流时，哭护短默认看到的是一个
    * 500异常，假如希望对限流结构进行自定义处理，可以考虑使用blockHandlerClass
    * 属性指定一个限流处理类，然后通过blockHandler属性指定具体异常处理方法
    * 这个异常处理方法必须与@SentinelResource注解描述的方法，返回值类型相同
    * ，同时必须是static方法，方法中参数可以是BlockException类型
    *
    * 当限流后，就不会执行doService方法里的内容 而是执行handeBlock方法内容
    * */
    @SentinelResource(value = "doService", blockHandlerClass = ResourceBlockHandler.class,
                      blockHandler ="handeBlock" )
    public String doService(){
        return "my resource";
    }

    @SentinelResource(value="resource",
            blockHandlerClass = ResourceBlockHandler.class,
            blockHandler = "doHandle")
    public String doGetResource(Integer id){
        return "the data's id is "+id;
    }

}
