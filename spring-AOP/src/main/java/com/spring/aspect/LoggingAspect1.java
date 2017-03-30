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


    private void writeLogs(String log) throws IOException{
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        LocalDateTime date = LocalDateTime.now();
        try{
            bw.write(log+" :Date Time :"+date);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
            fw.close();
        }
    }

    @Before("execution(* add*(..))")
    public void logBefore(JoinPoint joinPoint) throws IOException{
        writeLogs("\nlogging before all add* methods and join point"+ joinPoint.getSignature());
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

    @AfterThrowing(value = "execution(* throwException(..))", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("throwing exception");
    }

    @Around("execution(* throw*(..))")
    public void aroundTry(ProceedingJoinPoint pjp) throws Throwable {
        try {
            pjp.proceed();
        }catch (Exception e){
            System.out.println("Around used to catch exceptions");
        }
    }

    @Pointcut("@annotation(Deprecated)")
    public void depr(){
        System.out.println("this is deprecated pointcut");
    }
}
