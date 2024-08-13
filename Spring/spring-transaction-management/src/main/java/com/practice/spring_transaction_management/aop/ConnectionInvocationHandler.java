package com.practice.spring_transaction_management.aop;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

    Connection con;

    public ConnectionInvocationHandler(Connection con) {
        this.con = con;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Connection Trace "+method.toGenericString());
        Object returnValue = method.invoke(con,args);
        return returnValue;
    }
}
