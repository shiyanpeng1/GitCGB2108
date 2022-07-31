package com.jt;

import com.jt.common.util.StringUtils;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class StringTests {
    @Test
    public void testString(){
        String a="sss";
        System.out.println(StringUtils.isEmpty(a));
    }


}
