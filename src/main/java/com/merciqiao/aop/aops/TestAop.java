package com.merciqiao.aop.aops;

import com.merciqiao.aop.service.IPerson;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * Created by MMM on 2018/01/23.
 */
@Configuration
@Aspect
public class TestAop {
    @Autowired
    IPerson person;
    @Before("execution(* com.merciqiao.aop.service.Person.eat(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("before:想"+method.getName()+"身上有钱没,找室友借点钱");
    }
    @After("execution(* com.merciqiao.aop.service.Person.eat(..))")
    public void after(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("after:"+method.getName()+"完,散散步");
    }
    @Pointcut("execution(* com.merciqiao.aop.service.Person.eat(..))")
    public void excuteService(){}
    @Around("excuteService()")
    public Object cute(ProceedingJoinPoint thisJoinPoint){
        System.out.println("执行切面了...");
        Object[] args = thisJoinPoint.getArgs();//请求参数
        String id=(String)args[0];
        String name=(String)args[1];
        String result= person.eatFast(id,name);
        if(result!=""){
            return result;
        }
        else {
            try {
                return (String) thisJoinPoint.proceed();
            }
            catch (Throwable ex){
                return "吃不下饭";
            }
        }
    }
}
