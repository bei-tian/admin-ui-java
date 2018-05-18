package com.beitian.adminuijava.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class HttpAspect {

    @Autowired
    private HttpSession session;


    @Around("within(com.beitian.adminuijava.controller..*) && !within(com.beitian.adminuijava.controller.LoginController)")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object id = session.getAttribute("id");
        if(id == null) {
            //return "redirect:/login";
        }
        return proceedingJoinPoint.proceed();
    }
}
