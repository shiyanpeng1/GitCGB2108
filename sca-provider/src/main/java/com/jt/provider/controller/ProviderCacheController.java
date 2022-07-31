package com.jt.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RefreshScope
public class ProviderCacheController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;
    private   static List<String> cache = new CopyOnWriteArrayList<String>();
    @RequestMapping("/provider/cache01")
    public List doUseLocalCache01(){
        if(!useLocalCache){//不开启本地缓存 直接查询数据库
            return Arrays.asList("水果","蔬菜","手机");
        }
        if(cache.isEmpty()){//如果本地缓存是空的话 查询数据库数据存到缓存中
            List<String> cacheList = Arrays.asList("水果","蔬菜","手机");
            cache.addAll(cacheList);
        }
        return cache;

    }

}
