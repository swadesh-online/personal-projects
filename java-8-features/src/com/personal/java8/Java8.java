package com.personal.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 implements myInterface{
	
	/*
	 * @FunctionalInterface interface Operator<T> {
	 *  // T process(T a, T b); T
	 * process(T a); }
	 */
	
	@FunctionalInterface
	interface Operator<T>{
		T process(T a, T b);
	}
	
	private void testLambdaExp() {
	
		/**Using lambda expression
		 * 
		 * (parameters) -> { statements; }
		 */
		
		/*
		 * Operator<Integer> addOperation = (a, b) -> {return a + b;} ;
		 * System.out.println(addOperation.process(1, 2));
		 */
	
		/*
		 * Operator<Integer> squareOperation = (a) -> { return a*a; } ;
		 * System.out.println(squareOperation.process(5));
		 */
		
		//Using anonymous class
		Operator<Integer> addOperation = new Operator<Integer>() {
		  @Override
		  public Integer process(Integer a, Integer b) {
		    return a + b;
		  }
		};
		System.out.println(addOperation.process(2,3));
	}
	
	
	


	private void testStreamApi() {
		
		Double[] salaryArr= {1000.0,2000.0,15000.0,3000.0,3500.0} ;
		List<Double> salaries = new ArrayList<>(Arrays.asList(salaryArr));		
	
		List<Double> filteredSalaries = new ArrayList<Double>();
		for(Double salary : salaries) { //Iterating all salaries
			
			if(salary>2400) { //filtering 
				
				filteredSalaries.add(salary);  //adding it to the filteredList
			}
		}
		
		System.out.println("Normal Filtering : "+filteredSalaries);
	

		 List<Double> filteredSalariesUsingStream = salaries.stream() 
				 								 .filter(s-> s>2400) // filtered
				 								 .map(s -> s)  //the salary is mapped
				 								 .collect(Collectors.toList());
	
		 System.out.println("Using Stream : "+ filteredSalariesUsingStream);
	
	
	
	}

public static void main(String[] args) {
		
		Java8 obj = new Java8();
		
		//obj.testLambdaExp();
		obj.testStreamApi();
		
		//static reference to interface methods
		System.out.println(myInterface.hello());
		
		//non-static reference to interface methods
		System.out.println(obj.bye());
	}

}
