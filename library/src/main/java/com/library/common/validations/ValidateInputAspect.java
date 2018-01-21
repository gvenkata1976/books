package com.library.common.validations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateInputAspect {

	@Around("@annotation(ValidateInput)")
	public Object validate(ProceedingJoinPoint joinPoint) throws Throwable{

	    Object proceed = joinPoint.proceed();
	    Object[] args = joinPoint.getArgs();
	    for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	    return proceed;
	}
}
