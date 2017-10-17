

public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		if (a == 0) {
			throw new IllegalArgumentException("not a quadratic function");
		}
		String output = "";
		output += "\nDescription of the graph of: \ny = " + a + " x^2 + " + b + " x + " + c + "\n";
		output += direction(a, b, c);
		output += "\nAxis of Symmetry: ";
		output += axisofSym(a, b);
		output += "\nVertex: ";
		output += vertex(a, b, c);
		output += "\nx-intercept(s): ";
		output += quadForm(a, b, c);
		output += "\ny-intercept: " + c;
		return output;
	}

	public static String direction(double a, double b, double c) {

		if (a >= 0) {
			return "\nOpens: up";
		} else {
			return "\nOpens: down";
		}

	}

	public static double axisofSym(double a, double b) {
		double axs = -b / (2 * a);
		return axs;
	}

	public static String vertex(double a, double b, double c) {
		double x = axisofSym(a, b);
		double y = a * x * x + b * x + c;
		return "(" + x + ", " + y + ")";

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
	 * returns the max value of the number passed.
	 */
	public static double max(double operand1, double operand2) {
		if (operand1 > operand2) {
			return operand1;
		} else {
			return operand2;
		}
	}

	/*
	 * returns the smaller of the values passed
	 */
	public static double min(double operand1, double operand2) {
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
	 * returns an approximation of the square root of the value passed, rounded to
	 * two decimal places
	 */
	public static double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException();
		}
		double a = x / 2.0;

		while (absValue(x - a * a) > .005) {
			a = 0.5 * (x / a + a);
		}
		return round2(a);
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
	 * uses the coefficients of a quadratic equation in standard form and uses the
	 * quadratic formula to approximate the real roots, if any.
	 */
	public static String quadForm(double a, double b, double c) {
		double disc = discriminant(a, b, c);
		if (disc < 0) {
			return "none";
		} else {
			double root1 = (-b - sqrt(disc)) / (2 * a);
			double root2 = (-b + sqrt(disc)) / (2 * a);
			if (root1 == root2) {
				return "" + round2(root1);
			} else {
				return round2(min(root1, root2)) + " and " + round2(max(root1, root2));
			}
		}
	}
}
