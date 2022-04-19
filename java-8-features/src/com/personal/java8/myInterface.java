package com.personal.java8;

public interface myInterface {

	static String hello() {
		
		return "hello";
	}
	
	default String bye() {
		
		return "bye";
	}
}
