//Emi Okuyama
//November 21, 2017

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation

		Scanner console = new Scanner(System.in);
		Boolean done = false;
		while (!done == true) {
			String input = console.nextLine();
			System.out.println(produceAnswer(input));
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
		int[] op1Arr = splitString(op1);
		int[] op2Arr = splitString(op2);
		int whole1 = op1Arr[0], num1 = op1Arr[1], denom1 = op1Arr[2];
		int whole2 = op2Arr[0], num2 = op2Arr[1], denom2 = op2Arr[2];
		int[] result = handleOperation(oper, whole1, num1, denom1, whole2, num2, denom2);
		int whole = result[0], num = result[1], denom = result[2];

		// simplify mixed number
		whole += num / denom;
		num = num % denom;
		int factor = gcf(num, denom);
		num /= factor;
		denom /= factor;

		// if there is no fractional part just return the whole part
		if (num == 0) {
			return "" + whole;
		}
		return whole + "_" + num + "/" + denom;
	}

	// TODO: Implement this function to produce the solution to the input
	public static int[] splitString(String input) {
		int whole = 0;
		int num = 0;
		int denom = 1;
		if (input.contains("_")) {
			String[] oper = input.split("_");
			whole = Integer.parseInt(oper[0]);
			String[] operFraction = oper[1].split("/");
			num = Integer.parseInt(operFraction[0]);
			denom = Integer.parseInt(operFraction[1]);
		} else if (input.contains("/")) {
			String[] oper = input.split("/");
			num = Integer.parseInt(oper[0]);
			denom = Integer.parseInt(oper[1]);
		} else {
			whole = Integer.parseInt(input);
		}
		int[] fraction = { whole, num, denom };
		return fraction;
	}

	public static int[] handleOperation(String oper, int whole1, int num1, int denom1, int whole2, int num2,
			int denom2) {
		int whole = 0;
		int denom = 1;
		int num = 0;

		// rewrite - as + of negatives and / as * of reciprocal
		if (oper.equals("-")) {
			oper = "+";
			if (whole2 == 0) {
				num2 *= -1;
			} else {
				whole2 *= -1;
			}
		} else if (oper.equals("/")) {
			if (whole2 < 0) {
				num2 *= -1;
			}
			oper = "*";
			num2 = toImproperFracNumerator(whole2, num2, denom2);
			whole2 = 0;
			int temp = denom2;
			denom2 = num2;
			num2 = temp;
		}

		// when a whole number is negative transfer the sign to the numerator
		if (whole1 < 0) {
			num1 *= -1;
		}
		if (whole2 < 0) {
			num2 *= -1;
		}

		// we only impliment two operations + and *
		if (oper.equals("+")) {
			whole = whole1 + whole2;
			denom = lcd(denom1, denom2);
			num = 0;
			if (denom1 != denom) {
				num += num1 * (denom / denom1);
			} else {
				num += num1;
			}
			if (denom2 != denom) {
				num += num2 * (denom / denom2);
			} else {
				num += num2;
			}
		} else if (oper.equals("*")) {
			denom = denom1 * denom2;
			num = toImproperFracNumerator(whole1, num1, denom1) * toImproperFracNumerator(whole2, num2, denom2);
			whole = num / denom;
			num = num % denom;
		}

		// when both the whole part and numerator part are negative we only need to
		// return the whole as negative
		if (whole < 0 && num < 0) {
			num *= -1;
		}

		int[] result = { whole, num, denom };
		return result;
	}

	public static int toImproperFracNumerator(int number, int numerator, int denominator) {
		int mixedNumerator = (number * denominator + numerator);
		return mixedNumerator;
	}

	public static int min(int operand1, int operand2) {
		if (operand1 > operand2) {
			return operand2;
		} else {
			return operand1;
		}
	}

	public static boolean isDivisibleBy(int operand1, int operand2) {
		if (operand2 == 0) {
			throw new IllegalArgumentException();
		}
		return operand1 % operand2 == 0;
	}

	public static int lcd(int x, int y) {
		int result = x * y;
		for (int i = 2; i <= min(x, y); i++) {
			if (isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
				result = i;
			}
		}
		return result;
	}

	public static int gcf(int x, int y) {
		int result = 1;
		for (int i = 1; i <= min(x, y); i++) {
			if (isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
				result = i;
			}
		}
		return result;
	}
}