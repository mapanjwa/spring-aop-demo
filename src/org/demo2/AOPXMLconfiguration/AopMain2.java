package org.demo2.AOPXMLconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring2.xml");
		ShapeService2 shapeService = (ShapeService2) ctx.getBean("shapeService2");
		shapeService.getCircle2().setName("Dummy Name");
		
		//System.out.println(shapeService.getCircle2().getName());
		//System.out.println(shapeService.getTriangle2().getName());	
	}
}
