package com.practice.spring_transaction_management.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CallTracker {

    @Pointcut("within(com..service.*) " +
            "|| within(com.practice.spring_transaction_management.repository.*)")
    public void logMethodPointCut(){

    }

//    @Before(value = "logMethodPointCut()")
//    public void logInBeforeMethodCall(){
//        System.out.println("--- Method Called Started ---");
//    }
//
//    @After(value = "logMethodPointCut()")
//    public void logInAfterMethodCall(){
//        System.out.println("--- Method Called Complete ---");
//    }

    //Combine Above Two Methods
    @Around(value = "logMethodPointCut()")
    public Object logMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Method started : "+ proceedingJoinPoint.getSignature().getName());
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("Method Finished : "+ proceedingJoinPoint.getSignature().getName());
        return proceed;
    }

}
