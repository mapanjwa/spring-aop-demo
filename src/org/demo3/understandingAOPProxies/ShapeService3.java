package org.demo3.understandingAOPProxies;



public class ShapeService3 {

	private Circle3 circle3;
	private Triangle3 triangle3;
	public Circle3 getCircle3() {
		System.out.println("Circle's getter called");
		return circle3;
	}
	public void setCircle3(Circle3 circle3) {
		this.circle3 = circle3;
	}
	public Triangle3 getTriangle3() {
		return triangle3;
	}
	public void setTriangle3(Triangle3 triangle3) {
		this.triangle3 = triangle3;
	}
	
	
	
}
