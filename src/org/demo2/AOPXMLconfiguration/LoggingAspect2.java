package org.demo2.AOPXMLconfiguration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class LoggingAspect2 {
	
	//customized annotation - @Loggable2
	//@Around("allGetters()")
	public Object myAroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnVal = null;
		try {
			System.out.println("@Around - Before advice");
			returnVal = proceedingJoinPoint.proceed();
			System.out.println("@Around - After Returning");

		} catch (Throwable e) {
			System.out.println("@Around - After throwing");
		}
		System.out.println("@Around - After finally");
		return returnVal;
	}	
	
	//@Pointcut("execution(* get*())")
	//public void allGetters() {}
	
}


