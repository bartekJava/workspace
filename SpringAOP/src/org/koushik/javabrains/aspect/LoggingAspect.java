package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect 
{
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.toString());
	}
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")
	public void allCircleMethods(){}

}
