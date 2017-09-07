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
	 *  This method provides coefficients of a quadratic equation in standard form
	 *  returns the value of the discriminant
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
	
	public static String toMixedNum(int numerator, int denominator) {
		int number = (numerator / denominator);
		int newNumerator = (numerator % denominator);
		return number + "_" + newNumerator + "/" + denominator;
	}
	
	public static String foil(int w, int x, int y, int z, String variableName) {
		int a = (w * y);
		int b = ((w * z) + (x * y));
		int c = (x * z);
		return a + variableName + "^2" + "+" + b + variableName + "+" + c; 
	}
}
