package pl.altkom.hibernatejpa.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

	@After("execution(* pl.altkom.hibernatejpa.service.BorrowerServiceImpl.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		LOGGER.info(joinPoint.getSignature().getName() + " invoked.");
		System.out.println(joinPoint.getSignature().getName() + " invoked.");
	}

	@Around("execution(* pl.altkom.hibernatejpa.service.BorrowerServiceImpl.updateBorrower(..))")
	public void rethrowException(ProceedingJoinPoint point) throws Throwable {
		try {
			point.proceed();
			
		} catch (Exception e) {
			
			throw new RuntimeException();

		}
	}

}
