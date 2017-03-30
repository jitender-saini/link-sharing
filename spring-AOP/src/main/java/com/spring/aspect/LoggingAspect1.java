package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect1 {

    private static final String fileName = "aspect-logs.log";
    private File file = new File(fileName);


    private void writeLogs(String log){
        FileWriter fw = null;
        BufferedWriter bw = null;
        LocalDateTime date = LocalDateTime.now();
        try{
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(log+" :Date Time :"+date+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Before("execution(* add*(..))")
    public void logBefore(JoinPoint joinPoint){
        writeLogs("logging before all add* methods and join point :"+ joinPoint.getSignature());
    }

    @After("this(com.spring.services.UserService)")
    public void logAfter(){
        writeLogs("logging After methods in userServices using this");
    }

    @After("@annotation(Deprecated)")
    public void logDeprecated(){
        System.out.println("Deprecated method logging");
    }

    @AfterReturning(value="execution(* getValue*(..))",returning = "returnedValue")
    public void logAfterReturning(String returnedValue){
        writeLogs("value returned is "+ returnedValue);
    }

    @AfterThrowing(value = "execution(* throwException(..))", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("throwing exception");
    }

    @Around("execution(* throw*(..))")
    public void aroundTry(ProceedingJoinPoint pjp) {
        try {
            pjp.proceed();
        }catch (Throwable e){
            writeLogs("Around used to catch exceptions");
        }
    }

    @Pointcut("execution(* get*(..))")
    public void gettterPointcut(){
        writeLogs("this is deprecated pointcut");
    }

    @Before("args(String)")
    public void argsTryOnAllStringParameters(){
        System.out.println("args");
    }

    @AfterReturning(pointcut="execution(* get())", returning="returnString")
    public void getNameReturningAdvice(String returnString){
        System.out.println("getNameReturningAdvice executed. Returned String="+returnString);
    }

    @AfterThrowing("within(com.spring.services.UserService)")
    public void logExceptions(JoinPoint joinPoint){
        System.out.println("Exception thrown in UserService Method="+joinPoint.toString());
    }

    @Before("args(name)")
    public void logStringArguments(String name){
        System.out.println("String argument passed="+name);
    }

    public void targetTry(){

    }
}
