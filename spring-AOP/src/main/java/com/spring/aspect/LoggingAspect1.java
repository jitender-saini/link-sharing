package com.spring.aspect;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.scripts.JO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect1 {
    @Before("execution(* add*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        System.out.println("logging before");
    }

//    @After("this(com.spring.services.UserService)")
//    public void logAfter(){
//        System.out.println("logging After");
//    }

    @After("@annotation(Deprecated)")
    public void logDeprecated(){
        System.out.println("Deprecated method logging");
    }

    @AfterReturning(value="execution(* getValue*(..))",returning = "returnedValue")
    public void logAfterReturning(String returnedValue){
       // System.out.println(joinPoint.getSignature());
        System.out.println("value returned is "+ returnedValue);
    }

    @AfterThrowing(value = "execution(* divide*(..))", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("throwing exception");
    }
}
