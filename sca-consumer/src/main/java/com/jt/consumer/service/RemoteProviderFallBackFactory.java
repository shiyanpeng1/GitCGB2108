package com.jt.consumer.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteProviderFallBackFactory implements FallbackFactory<RemoteProviderService> {

    @Override
    public RemoteProviderService create(Throwable throwable) {
        return new RemoteProviderService() {
            @Override
            public String echoMessage(String msg) {
                return "服务正在更新，请稍后访问";
            }
        };
    }
}
