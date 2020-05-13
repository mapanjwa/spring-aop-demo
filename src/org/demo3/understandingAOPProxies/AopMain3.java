package org.demo3.understandingAOPProxies;


public class AopMain3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring3.xml");
		//ShapeService3 shapeService = (ShapeService3) ctx.getBean("shapeService3");
		//shapeService.getCircle3();

		//creating my own factory bean
		FactoryService factory = new FactoryService();
		//passing proxy of ShapeService - ShapeServiceProxy
		//proxy class is calling the logging advice before calling the actual ShapeService method 
		ShapeService3 shapeService3 = (ShapeService3)factory.getBean("shapeService3");
		shapeService3.getCircle3();
		
	}
}
