package org.demo2.AOPXMLconfiguration;

public class Circle2 {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	/*@Loggable2
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's set name and return called");
		return name;
	}*/
	
}
