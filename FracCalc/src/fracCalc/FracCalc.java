package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation

		Scanner console = new Scanner(System.in);
		Boolean done = false;
		while (!done == true) {
			String input = console.nextLine();
			System.out.println("\n" + produceAnswer(input));
			if (input.equals("quit")) {
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
		String[] fractions = input.split(" ");
		String op1 = fractions[0];
		String oper = fractions[1];
		String op2 = fractions[2];
		int whole = 0;
		int num = 0;
		int denom = 1;
		if (op2.contains("_")) {
			String[] secondOp = op2.split("_");
			whole = Integer.parseInt(secondOp[0]);
			String[] op2Fraction = secondOp[1].split("/");
			num = Integer.parseInt(op2Fraction[0]);
			denom = Integer.parseInt(op2Fraction[1]);
		}
		else if(op2.contains("/")) {
			String[] secondOp = op2.split("/");
			num = Integer.parseInt(secondOp[0]);
			denom = Integer.parseInt(secondOp[1]);
		}
		else {
		whole = Integer.parseInt(op2);
		}
	return "whole:" + whole + " numerator:" + num + " denominator:" + denom;
	}

// TODO: Implement this function to produce the solution to the input
}