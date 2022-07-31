package com.jt.provider.service;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest Request,
                       HttpServletResponse Response,
                       BlockException e) throws Exception {

         //1.设置响应数据的编码(中文可能会出现乱码)
        Response.setCharacterEncoding("utf-8");
        //2.告诉浏览器你要响应的内容类型以及编码
        Response.setContentType("application/json;charset=utf-8");
        //3.构建响应数据
        Map<String,Object> map = new HashMap<>();
        map.put("status", 429);
        map.put("message", "访问太过频繁");
        //将map转化为json格式字符串  ---直接输出map貌似也可以
        String jsonStr = new ObjectMapper().writeValueAsString(map);
        //4.将响应数据写到客户端
        PrintWriter writer = Response.getWriter();
        writer.println(jsonStr);
        writer.flush();

    }
}
