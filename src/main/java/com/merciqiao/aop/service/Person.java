package com.merciqiao.aop.service;

import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2018/01/23.
 */
@Component
public class Person implements  IPerson{
    @Override
    public String eat(String id,String name) {
        System.out.println("ing:吃饭");
        return "慢点吃饭";
    }
    @Override
    public String eatFast(String id,String name){
        System.out.println("ing:吃饭");
        return "快点吃饭";
    }
}
