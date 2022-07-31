package com.jt.provider.service;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DefaultRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
       // String origin = request.getParameter("origin");
       // return origin;
        //获取请求中的ip地址，基于ip地址进行黑白名单设计
        String ip = request.getRemoteAddr();
       // System.out.println("ip"+ip);
        return ip;

    }
}