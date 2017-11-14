package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    		Scanner scanner1 = new Scanner(System.in);
    		boolean done = false;
    		while(!done) {
    			System.out.print("Type two mixed fractions");	
    			String fractions = scanner1.next();
    			System.out.println(produceAnswer(fractions));
    			System.out.println("are you done? type yes or no");
    			String finished = scanner1.next();
    			if(finished.equals("yes")) {
    				done = true;
    			}
    		}

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] fracArr = input.split(" ");
		String op2 = fracArr[2];
		int whole = 0;
		int num = 0;
		int denom = 1;
		for (int i = 0; i < op2.length(); i++) {
			
		}
		String[] mixedNum = op2.split("_");
		whole = Integer.parseInt(mixedNum[0]);
		String fraction = mixedNum[1];
		String[] fraction1 = fraction.split("/");
		num = Integer.parseInt(fraction1[0]);
		denom = Integer.parseInt(fraction1[1]);
		return "whole:" + whole + " numerator:" + num + " denominator:" + denom;  
		
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
