package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		do {
			Scanner console = new Scanner(System.in);
			String input = console.nextLine();
			if (input.equals("quit"))
				;
			System.out.println(produceAnswer(input));
		} while (true);
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
		String[] inputarray = input.split(" ");
		String firstoperand = inputarray[0];
		String operator = inputarray[1];
		String secondoperand = inputarray[2];
		String[] split1 = splitOperand(firstoperand);
		String[] split2 = splitOperand(secondoperand); 
														
		int[] opernums1 = new int[3];
		for (int i = 0; i < split1.length; i++) {
			opernums1[i] = toNumber(split1[i]);
		}
		int[] opernums2 = new int[3];
		for (int i = 0; i < split2.length; i++) {
			opernums2[i] = toNumber(split2[i]);
		} 
		int[] operand1 = new int[2];
		int[] operand2 = new int[2];
		
		operand1 = toImproperFrac(opernums1);
		operand2 = toImproperFrac(opernums2);
		int[] answer = new int[2];

		if (operator.equals("+") || operator.equals("-")) {
			addOrsubtract(operand1, operand2, answer, operator);
		} else {
			multiplyOrdivide(operand1, operand2, answer, operator);
		}

		String ans = "" + answer[0] + "/" + answer[1];
		
		return ans;
	}

	// TODO: Implement this function to produce the solution to the input
	public static int toNumber(String numberstr) {
		int negsign = 1;
		if (numberstr.contains("-")) {
			numberstr = numberstr.substring(1);
			negsign = -1;
		}
		int i = 0;
		while (i >= 0) {
			String j = "" + i;
			if (numberstr.equals(j)) {
				return i * negsign;
			}
			i++;
		}
		return 0;
	}

	public static int[] toImproperFrac(int[] arr) {
		int multiplier = 1;
		if (arr[0] < 0) {
			arr[0] *= -1;
			multiplier = -1;
		}
		int top;
		top = multiplier * ((arr[0] * arr[2]) + arr[1]);
		int[] impropfrac = { top, arr[2] };
		return impropfrac;
	}

	public static String[] splitOperand(String operand) {
		String wholenum = "0";
		String numerator = "0";
		String denominator = "1";
		String[] fraction = operand.split("_");
		wholenum = fraction[0];
		String fracofmxnum = "";
		if (fraction.length == 2) {
			fracofmxnum = fraction[1];
			fracofmxnum.split("/");
			numerator = fracofmxnum.split("/")[0];
			denominator = fracofmxnum.split("/")[1];
		} else if (wholenum.contains("/")) {
			numerator = wholenum.split("/")[0];
			denominator = wholenum.split("/")[1];
			wholenum = "0";
		}
		String[] splitted = new String[3];
		splitted[0] = wholenum;
		splitted[1] = numerator;
		splitted[2] = denominator;
		return splitted;
	}

	public static void commonDenom(int arr1[], int arr2[]) {
		arr1[0] = arr2[1] * arr1[0];
		arr2[0] = arr1[1] * arr2[0];
		int denom = arr1[1];
		arr1[1] = arr1[1] * arr2[1];
		arr2[1] = denom * arr2[1];
	}
	
		
	
	public static void addOrsubtract(int[] arr1, int[] arr2, int[] answer, String operator) {
		commonDenom(arr1, arr2);
		if (operator.equals("-")) {
			arr2[0] = arr2[0] * (-1);
		}
		answer[0] = arr1[0] + arr2[0];
		answer[1] = arr1[1];
	}

		
	public static void multiplyOrdivide(int[] arr1, int[] arr2, int[] answer, String operator) {
		if (operator.equals("/")) {
			int save = arr2[0];
			arr2[0] = arr2[1];
			arr2[1] = save;
		}
		answer[0] = arr1[0] * arr2[0];
		answer[1] = arr1[1] * arr2[1];
	}
}
	
	