package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            bw.write("Date Time :: "+date+" :: "+log+"\n");
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

    // Q2 Add a logging statement before and after the method ends
    // Q7 Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
    @Before("execution(* add*(..))")
    public void logBefore(JoinPoint joinPoint){
        writeLogs("logging before all add* methods and join point :"+ joinPoint.getSignature());
    }

    //Q1 & 2  Create a logging aspect. Create a pointcut to log all methods Of services .
    @After("this(com.spring.services.UserService)")
    public void logAfter(){
        writeLogs("logging After methods in userServices using this");
    }

    //Q3 Log all the methods which throw IOException
    @AfterThrowing(value = "execution(* *(..))",throwing = "e")
    public void afterIOException(IOException e){
        writeLogs("Throwing IOExceptions");
    }

    //Q4 Log all the methods annotated with @Deprecated Annotation
    @After("@annotation(Deprecated)")
    public void logDeprecated(){
        writeLogs("Deprecated method logging");
    }

    @AfterReturning(value="execution(* get*(..))",returning = "returnedValue")
    public void logAfterReturning(String returnedValue){
        writeLogs("value returned is "+ returnedValue);
    }

    @AfterThrowing(value = "execution(* throwException(..))", throwing = "e")
    public void afterThrowing(Exception e){
        writeLogs("throwing exception");
    }

    @Around("execution(* throw*(..))")
    public void aroundTry(ProceedingJoinPoint pjp) {
        try {
            pjp.proceed();
        }catch (Throwable e){
            writeLogs("Around used to catch exceptions");
        }
    }



    //Q5  Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
    @Before("args(String)")
    public void argsTryOnAllStringParameters(){
        writeLogs("Before using any String arguments");
    }

    @AfterReturning(pointcut="execution(* get())", returning="returnString")
    public void getNameReturningAdvice(String returnString){
        writeLogs("getNameReturningAdvice executed. Returned String="+returnString);
    }

    //Q5
    @AfterThrowing("within(com.spring.services.UserService)")
    public void logExceptions(JoinPoint joinPoint){
        writeLogs("Exception thrown in UserService Method="+joinPoint.toString());
    }

    //Q5
    @Before("args(firstName)")
    public void logStringArguments(String firstName){
        writeLogs("String argument passed="+firstName);
    }
    //Q6
    @Pointcut("@annotation(Deprecated)")
    public void deprecated(){
        System.out.println("this is deprecated pointcut");
    }
}
