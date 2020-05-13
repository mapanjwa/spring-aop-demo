package org.demo3.understandingAOPProxies;


//created my own factory to return bean
//demo example
public class FactoryService {

	public Object getBean(String beanType) {
		if (beanType.equalsIgnoreCase("shapeService3")) {
			//returns proxy instead of ShapeService Object
			return new ShapeServiceProxy();
		}
		if (beanType.equalsIgnoreCase("circle3")) {
			return new Circle3();
		}
		if (beanType.equalsIgnoreCase("triangle3")) {
			return new Triangle3();
		}
		return null;
	}
}
