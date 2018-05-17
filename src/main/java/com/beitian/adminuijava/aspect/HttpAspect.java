package com.beitian.adminuijava.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.beitian.adminuijava.controller.LoginController.*(..))")
    public void doBefore() {
        System.out.println("eeeee");
    }
}
