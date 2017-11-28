package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner scanner1 = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.print("Type two mixed fractions");
			String fractions = scanner1.next();
			System.out.println(produceAnswer(fractions));
			System.out.println("are you done? type yes or no");
			String finished = scanner1.next();
			if (finished.equals("yes")) {
				done = true;
			}
		}

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		String[] fracArr = input.split(" ");
		String first =  fracArr[2] ;
		int whole = 0;
		int num = 0;
		int denom = 1;
		  if (first.indexOf('_') >= 0) {
			whole = Integer.parseInt(first.substring(0, first.indexOf('_')));
			        	num = Integer.parseInt(first.substring(first.indexOf('_') + 1, first.indexOf('/')));
			         	denom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
			         } else if (first.indexOf('/') >= 0) {
			         	num = Integer.parseInt(first.substring(0, first.indexOf('/')));
			         	denom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
			         } else {
			         	whole = Integer.parseInt(first);
			}
		return "whole:" + whole + " numerator:" + num + " denominator:" + denom;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	

	public static String toImproperFrac(int number, int numerator, int denominator) {
		int mixedNumerator = (number * denominator + numerator);
		return mixedNumerator + "/" + denominator;

	}
	
	public static boolean isDivisibleBy(int operand1, int operand2) {
		if (operand2 == 0) {
			throw new IllegalArgumentException();
		}
		return operand1 % operand2 == 0;
	}
	
	public static int min(int operand1, int operand2) {
		if (operand1 > operand2) {
			return operand2;
		} else {
			return operand1;
		}
	}
	
	public static int gcd(int denom1, int denom2) {
		int result = 1;
		for (int i = 1; i <= min(denom1, denom2); i++) {
			if (isDivisibleBy(denom1, i) && isDivisibleBy(denom2, i)) {
				result = i;
			}
		}
		return result;
	}

}
