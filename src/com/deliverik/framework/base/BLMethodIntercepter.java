package com.deliverik.framework.base;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BLMethodIntercepter implements MethodBeforeAdvice {

    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {

    	//System.out.println(arg2.toString());
    	//List<UserInfo> u = userTBDAO.findAll();
    	//if(true) throw new BLException(BLErrorType.LOGIN_ERROR, "ADCO00000.E002" );
    }
}
