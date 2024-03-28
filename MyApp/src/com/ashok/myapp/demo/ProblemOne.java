package com.ashok.myapp.demo;

import java.util.function.Consumer;

public class ProblemOne {

	public static void main(String[] args) {
		
		/** Problem statement-1
		 * Write a method that accepts a function where the function parameters 
		 * can be 1..n and return type is void and this method should retry 
		 * the function 5 times if the function throws an exception
		 *
		 * eg) 
		 * void test(int x, int ) {
		 * void test1(int x, int y, int z) {}
		 * void retry(???)
		 * test(1, 2), test1(3, 4, 5)
		 */
		ProblemOne obj = new ProblemOne();
		//calling retry method by passing test(1,2)
		System.out.println("\n*******Calling the fucntion test(1,2) *******");
		obj.retry(arguments -> 
			obj.test((int)arguments[0], (int)arguments[1]), 
			1, 2);
		//calling retry method by passing test1(3,4,5)
		System.out.println("\n*******Calling the fucntion test1(3,4,5) *******");
	    obj.retry(arguments -> 
	    	obj.test1((int)arguments[0], (int)arguments[1], (int)arguments[2]),
	    	3, 4, 5);
	}
	
	/**
	 * retry method that accepts function and variable arguments as arguments
	 * and executes 5 times if calling method throws any exception
	 * @param function
	 * @param args
	 */
	 void retry(Consumer<Object[]> function, Object... args) {
        int retryCountVal = 0;
        //loop will execute 5 times until retryCountVal reaches to 5
        while (retryCountVal < 5) {
            try {
                function.accept(args);
                return; // If no exception occurred, then exit from the method
            } catch (Exception e) {
            	//printing the exception message
                System.out.println("Exception occurred: " + e.getMessage());
                //incrementing retryCountVal
                retryCountVal++;
            }
        }
        if(retryCountVal==5) {
        	System.out.println("Max retry attempts "+retryCountVal+" reached.");
        }
     }
	 /**
	  * test method that accepts two integer arguments
	  * @param x
	  * @param y
	  */
	 void test(int x, int y) {
		System.out.println("Testing test(" + x + ", " + y + ")");
	 	if (x == 1 && y == 2) {
	 		//throwing exception if x equal to 1 and y equal to 2
            throw new RuntimeException("Exception thrown...");
        } else {
            System.out.println("Test successful!");
        }
	 }
	 /**
	  * test1 method that accepts three integer arguments
	  * @param x
	  * @param y
	  * @param z
	  */
     void test1(int x, int y, int z) {
        System.out.println("Testing test1(" + x + ", " + y + ", " + z + ")");
        if (x == 3 && y == 4 && z == 5) {
        	//throwing exception if x equal to 3 and y equal to 4 and z equal to 5
            throw new RuntimeException("Exception thrown...");
        } else {
            System.out.println("Test1 successful!");
        }
    }
}
