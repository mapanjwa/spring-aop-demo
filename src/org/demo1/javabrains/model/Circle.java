package org.demo1.javabrains.model;

public class Circle {
	private String name;

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
		//throw new RuntimeException();
	}

	public String getName() {
		return name;
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's set name and return called");
		return name;
	}
	
}
