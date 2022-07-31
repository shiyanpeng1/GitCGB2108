package com.jt.provider.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component //不加貌似也不影响
public class ResourceBlockHandler {
   public static String handeBlock(BlockException ex){
       log.error("被限流了");
       return "访问太过频繁,请稍后访问!!!!";
   }
   //doGetResource方法有参数，这就得有参数接受
    public static String doHandle(Integer id,BlockException ex){
        log.error("被限流了");
        return "访问太过频繁,请稍后访问!!!!";
    }
}
