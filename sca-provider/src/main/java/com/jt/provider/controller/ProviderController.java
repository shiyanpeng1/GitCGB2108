package com.jt.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${server.port:8080}")
    private  String server;
    @GetMapping("/provider/echo/{msg}")
    public String doRestEcho1(@PathVariable String msg) throws InterruptedException {
        return server+"say hello  "+msg;
    }
}
