package org.demo1.javabrains;

import org.demo1.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = (ShapeService) ctx.getBean("shapeService");
		shapeService.getCircle().setName("Dummy Name");
		shapeService.getCircle().setNameAndReturn("Dummy Name 2");
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
	
		
		
		
		
	}

}
