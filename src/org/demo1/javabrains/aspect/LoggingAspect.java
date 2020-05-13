package org.demo1.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.demo1.javabrains.model.Circle;

@Aspect
public class LoggingAspect {
	
	//run below method when getName() is called, irrespective of the object. 
	//will be called for Triangle and Circle
	//@Before("execution(public String getName())")
	
	//run below method when getName() is called, only for the Circle object.
	//@Before("execution(public String org.demo1.javabrains.model.Circle.getName())")
	
	//run below method when method begin with "get" and return String will be called
	//@Before("execution(public String get*())")
	
	//run below method when method begin with "get" and return type anything but with access specifier "Public" will be called
	//@Before("execution(public * get*())")
	
	//run below method when method begin with "get" and return type anything will be called irrespective of the access specifier
	//@Before("execution(* get*())")
	
	//run below method when method begin with "get" and return type anything will be called irrespective of the access specifier
	// * in the method argument indicates 1 or more arguments	
	//@Before("execution(* get*(*))")
	
	//run below method when method begin with "get" and return type anything will be called irrespective of the access specifier
	// .. indicates 0 or more arguments	
	//@Before("execution(* get*(..))")
	
	//run below method when method begin with "get" and return type anything will be called irrespective of the access specifier
	// .. indicates 0 or more arguments	
	//any class within package org.demo1.javabrains.model
	//@Before("execution(* org.demo1.javabrains.model.*.get*(..))")
	
	
	//@Before("execution(* get*())")
	@Before("allGetters() && allCircleMethods()")
	public void loggingAdvice(){
		System.out.println("Advice run. Get Method called");
	}
	
	//@Before("execution(* get*())")
	@Before("allGetters() && allTriangleMethods()")
	public void secondAdvice() {
		System.out.println("Second Advice executed");		
	}
	
	//JoinPoint means all the places in your code where you can apply advice
	//advice can be applied to the methods in Spring
	//but with aspectJ, advice can be applied when variable value changes
	//with the help of jointPoint we can identify the places where advice is applied
	//syntax: used in the argument of advice
	@Before("allCircleMethods()")
	public void loggingAdviceUsingJointPoint(JoinPoint joinPoint){
		System.out.println(joinPoint.toString());
		Circle circle = (Circle)joinPoint.getTarget();
		//object circle can be used in the advice
		System.out.println("Name of circle:"+circle.getName());
	}
	
	
	@Before("args(String)")
	public void stringArgumentsMethodsway1() {
		System.out.println("A method that takes String arguments has been called");
	}
	
	@Before("args(name)")
	public void stringArgumentsMethodsway2(String name) {
		System.out.println("String argument value is:"+ name);
	}
	
	//executes after method completes - no matter of success or not-success
	//acts like a finally block
	@After("args(name)")
	public void afterAdviceStringArgumentsMethodsway2(String name) {
		System.out.println("After advice String argument value is:"+ name);
	}
	
	//executes after method completes - will run if target method executes 
	//successfully and return
	// un -comment in Circle class throws statement
	//and comment 		
	//<property name="name" value="Circle Name"></property>
	// in spring.xml
	@AfterReturning("args(name)")
	public void afterReturningAdviceStringArgumentsMethodsway2(String name) {
		System.out.println("After returning advice String argument value is:"+ name);
	}
	
	//advice to be executed for methods having String as input
	//output type as String
	@AfterReturning(pointcut="args(name)", returning = "returnString")
	public void afterReturningsetterReturn(String name, String returnString) {
		System.out.println("for setter and return demo with input: "+ name + " output value : "+ returnString);
	}
	
	//advice to be executed for methods having String as input
	//output type as any object
	/*@AfterReturning(pointcut="args(name)", returning = "returnString")
	public void afterReturningsetterReturn(String name, Object returnString) {
		System.out.println("for setter and return demo with input: "+ name + " output value : "+ returnString);
	}*/
	
	
	
	//executes after method completes - will run if target method executes 
	//and return exception
	// un -comment in Circle class throws statement
	//and comment 		
	//<property name="name" value="Circle Name"></property>
	// in spring.xml
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name) {
		System.out.println("An exception has been thrown:"+ name);
	}
	
	//return this method for all methods with args(String) 
	//and throw runtime exception
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvicewithReturn(String name, RuntimeException ex) {
		System.out.println("A Run time exception has been thrown:"+ ex);
	}

	/*
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvicewithReturn(String name, Exception ex) {
		System.out.println("A exception has been thrown:"+ ex);
	}
	*/
	
	
	//un-comment this to execute and comment other 2 @Around advice annotation
	//only one around advice at one time, else you will get circular error
	
	//1. need to have at least ProceedingJoinPoint as an argument -  compulsory
	//2. use proceedingJoinPoint.proceed() - compulsory
	//getter methods will return String - return type as object
	/*@Around("allGetters()")
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
*/
	
	//1. need to have at least ProceedingJoinPoint as an argument -  compulsory
	//2. use proceedingJoinPoint.proceed() - compulsory
	//getter methods will return String - return type as object
	/*@Around("args(name)")
	public void myAroundMethodforVoidreturn(ProceedingJoinPoint proceedingJoinPoint, String name) {
		
		try {
			
			System.out.println("@Around - Before advice : "+ name);
			
			proceedingJoinPoint.proceed();
			
			System.out.println("@Around - After Returning: "+ name);

		} catch (Throwable e) {
			System.out.println("@Around - After throwing: "+ name);

		}
		System.out.println("@Around - After finally: "+ name);
	
	}*/


	//customized annotation - @Loggable 
	@Around("@annotation(org.demo1.javabrains.aspect.Loggable)")
	public Object myAroundMethodcustomizedannotation(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnVal = null;
		try {
			
			System.out.println("@Loggable - Before advice");
			
			returnVal = proceedingJoinPoint.proceed();
			
			System.out.println("@Loggable - After Returning");

		} catch (Throwable e) {
			System.out.println("@Loggable - After throwing");

		}
		System.out.println("@Loggable - After finally");
		return returnVal;
	}

	
	
	/*NOTE:
	 * 	Expression execution(* get*()) is a pointcut for loggingAdvice
	 *  Expression execution(* get*()) is a pointcut for secondAdvice
	 * */
	
	//we can define pointcut expression separately and use in the advice expression.
	//defined the dummy method allGetters
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	
	//way1: pointcut applicable for all the Circle methods
	@Pointcut("execution(* org.demo1.javabrains.model.Circle.*(..))")
	public void allCircleMethods() {}
	
	//way2: pointcut applicable for all the Triangle methods
	@Pointcut("within(org.demo1.javabrains.model.Triangle)")
	public void allTriangleMethods() {}

	//way2: pointcut applicable for all the Model methods
	@Pointcut("within(org.demo1.javabrains.model.*)")
	public void allModelMethods() {}
	
	
	@Pointcut("execution(* org.demo1.javabrains.service.*Service.*(..))")
	public void methodForAllclassesendwithService() {}
	
	
	
	/*
	 * within take parameter as class name
	 * execution take parameter as method name
	 * */
	
}


