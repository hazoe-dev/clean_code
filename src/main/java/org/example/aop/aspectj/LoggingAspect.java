package org.example.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class LoggingAspect {
    @Around("execution(* org.example.aop.aspectj.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Around("execution(* org.example.aop.aspectj.UserService.getUserById(int)) && args(id)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, int id) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            // Proceed with the original method execution
            return joinPoint.proceed(new Object[]{id});
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " executed in (specific) " + executionTime + "ms");
        }
    }
}
