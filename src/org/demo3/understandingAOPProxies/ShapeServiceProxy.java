package org.demo3.understandingAOPProxies;

public class ShapeServiceProxy extends ShapeService3 {

	public Circle3 getCircle3() {
		//calling logging advice
		new LoggingAspect3().myloggingAdvice();
		//calling the target object
		return super.getCircle3();
	}
}
