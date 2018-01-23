package com.merciqiao.aop;

import com.merciqiao.aop.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by MMM on 2018/01/23.
 */
@Component
public class Test {
    @Autowired
    IPerson person;
    @PostConstruct
    public void main(){
        String result= person.eat("001","张三");
        System.out.println("执行的是:"+result);
    }
}
