package com.practice.spring_transaction_management.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    Connection con;

    @Around("target(javax.sql.DataSource)")
    public Object logDataSource(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("DataBase tracker "+ proceedingJoinPoint.getSignature());
        Object proceed = proceedingJoinPoint.proceed();
        if(proceed instanceof Connection){
            Connection con = (Connection) proceed;
//            Object object = Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(), new Class[]{Connection.class},
//                    (proxy, method, args) -> {
//                        System.out.println("Connection Trace " + method.toGenericString());
//                        Object returnValue = method.invoke(con, args);
//                        return returnValue;
//                    });
        }
        System.out.println("Connection Obj = "+proceed);
        return proceed;
    }

}
