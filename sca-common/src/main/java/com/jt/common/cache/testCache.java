package com.jt.common.cache;


import sun.security.util.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class testCache {
    private static List<String> cache = new CopyOnWriteArrayList<>();
    public static List selectAll() {
        if(cache.isEmpty()) {
            synchronized (cache) {
                if (cache.isEmpty()) {
                    List<String> cacheList = Arrays.asList("水果", "蔬菜", "手机");
                    cache.addAll(cacheList);
                }

            }
        }return cache;
    }

    public static void main(String[] args) {
        Thread t1= new Thread(){
            @Override
            public void run() {
                System.out.println(selectAll());
            }
        };
        Thread t2= new Thread(){
            @Override
            public void run() {
                System.out.println(selectAll());
            }
        };
        Thread t3= new Thread(){
            @Override
            public void run() {
                System.out.println(selectAll());
            }
        };
        Thread t4= new Thread(){
            @Override
            public void run() {
                System.out.println(selectAll());
            }
        };
        Thread t6= new Thread(){
            @Override
            public void run() {
                System.out.println(selectAll());
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t6.start();


    }
}
