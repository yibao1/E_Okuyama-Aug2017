/* Emi Okuyama
 * September 5th, 2017
 * This is our home grown library that will contain various mathematical methods. 
 */
public class Calculate {

	/*
	 * This method takes an integer and returns its square.
	 */
	public static int square(int operand) {
		int squared = operand * operand;
		return squared;
	}

	/*
	 * This method takes an integer and returns its cube.
	 */
	public static int cube(int operand) {
		int cubed = operand * operand * operand;
		return cubed;
	}

	/*
	 * This method takes two doubles and returns the average.
	 */
	public static double average(double operand1, double operand2) {
		double average = (operand1 + operand2) / 2;
		return average;
	}

	/*
	 * This method takes 3 doubles and returns the average.
	 */
	public static double average(double operand1, double operand2, double operand3) {
		double average = (operand1 + operand2 + operand3) / 3;
		return average;
	}

	/*
	 * This method converts an angle measure given in radians into degrees.
	 */
	public static double toDegrees(double operand) {
		double deg = (operand * (180 / 3.14159));
		return deg;
	}

	/*
	 * This method converts an angle measure given its degrees into radians
	 */
	public static double toRadians(double operand) {
		double rad = (operand * (3.14159 / 180));
		return rad;
	}

	/*
	 * This method provides coefficients of a quadratic equation in standard form
	 * returns the value of the discriminant
	 */
	public static double discriminant(double a, double b, double c) {
		double discriminant = ((b * b) - 4 * a * c);
		return discriminant;

	}

	/*
	 * This method converts mixed numbers into an improper fraction.
	 */
	public static String toImproperFrac(int number, int numerator, int denominator) {
		int mixedNumerator = (number * denominator + numerator);
		return mixedNumerator + "/" + denominator;

	}

	/*
	 * This method converts an improper fraction to a mixed number.
	 */
	public static String toMixedNum(int numerator, int denominator) {
		int number = (numerator / denominator);
		int newNumerator = (numerator % denominator);
		return number + "_" + newNumerator + "/" + denominator;
	}

	/*
	 * This method converts a binomial multiplication of the form (ax + b)(cx + d)
	 * into a quadratic equation of the form ax^2 + bx + c.
	 */
	public static String foil(int w, int x, int y, int z, String variableName) {
		int a = (w * y);
		int b = ((w * z) + (x * y));
		int c = (x * z);
		return a + variableName + "^2" + "+" + b + variableName + "+" + c;
	}

	/*
	 * This method determines whether or not one integer is evenly divisible by
	 * another.
	 */
	public static boolean isDivisibleBy(int operand1, int operand2) {
		return operand1 % operand2 == 0;
	}

	/*
	 * This method returns the absolute value of the number passed.
	 */
	public static double absValue(double operand1) {
		if (operand1 > 0) {
			return operand1;
		} else {
			return operand1 * -1;
		}
	}

	/*
	 * returns the absolute value of the number passed.
	 */
	public static double max(double operand1, double operand2) {
		if (operand1 > operand2) {
			return operand1;
		} else {
			return operand2;
		}
	}

	/*
	 * overloads max method.
	 */
	public static double max(double operand1, double operand2, double operand3) {
		if (operand1 > operand2) {
			if (operand3 > operand1) {
				return operand3;
			} else {
				return operand1;
			}
		} else {
			if (operand3 > operand2) {
				return operand3;
			} else {
				return operand2;
			}
		}
	}

	/*
	 * returns the smaller of the values passed
	 */
	public static int min(int operand1, int operand2) {
		if (operand1 > operand2) {
			return operand2;
		} else {
			return operand1;
		}
	}

	/*
	 * rounds a double correctly to 2 decimal places and returns a double.
	 */
	public static double round2(double operand1) {
		operand1 = operand1 * 1000;
		if (operand1 % 10 < 5) {
			operand1 = operand1 - (operand1 % 10);
			return operand1 / 1000;
		} else {
			operand1 = operand1 - (operand1 % 10) + 10;
			return operand1 / 1000;
		}
	}

	/*
	 * raises a value to a positive integer power
	 */
	public static double exponent(double baseNum, int exponent) {
		double result = 1.0;
		for (int i = 0; i < exponent; i++) {
			result = result * baseNum;
		}
		return result;
	}

	/*
	 * returns the factorial of the value passed
	 */
	public static int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	/*
	 * determines whether or not an integer is prime.
	 */
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (isDivisibleBy(n, i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * finds the greatest common factor of two integers
	 */
	public static int gcf(int x, int y) {
		int result = 1;
		for (int i = 1; i <= min(x, y); i++) {
			if (isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
				result = i;
			}
		}
		return result;
	}

	/*
	 * returns an approximation of the square root of the value passed, rounded to
	 * two decimal places
	 */
	public static double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException ()
		}
		double a = x / 2.0;
		while (absValue(x - a * a) > .005) {
			a = 0.5 * (x / a + a);
		}
		return round2(a);
	}
	
	/*
	 * uses the coefficients of a quadratic equation in standard form and uses
	 * the quadratic formula to approximate the real roots, if any.
	 */
	public static String quadForm(int a, int b, int c) {
		if (discriminant(a, b, c) < 0) {
			
	}
}
