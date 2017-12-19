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

	public static String produceAnswer(String input) {
		String[] fractions = input.split(" ");
		String op1 = fractions[0];
		String oper = fractions[1];
		String op2 = fractions[2];
		int[] op1Arr = splitString(op1);
		int[] op2Arr = splitString(op2);
		int whole1 = op1Arr[0], num1 = op1Arr[1], denom1 = op1Arr[2];
		int whole2 = op2Arr[0], num2 = op2Arr[1], denom2 = op2Arr[2];
		Fraction x = new Fraction(whole2, num2, denom2);
		x.toMixedNumber();
		return x.toString();
	}

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

}