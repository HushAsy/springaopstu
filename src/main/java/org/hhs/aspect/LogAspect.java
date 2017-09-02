package org.hhs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hhs.annotation.Action;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by hewater on 2017/9/2.
 */
@Aspect
@Component
public class LogAspect {
    private ThreadLocal<Long> localTime = new ThreadLocal<Long>();

    @Pointcut("@annotation(org.hhs.annotation.Action)")
    public void annotationPointCut(){};

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name());
    }

    @Before("execution(* org.hhs.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        Long startTime = System.currentTimeMillis();
        localTime.set(startTime);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截before: " + method.getName());
    }

    @After("execution(* org.hhs.service.DemoMethodService.*(..))")
    public void methodAfter(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截after: " + method.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long startTime = localTime.get();
        System.out.println("execTime: "+(System.currentTimeMillis()-startTime));
    }
}
