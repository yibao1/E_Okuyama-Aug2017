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
		int cube = operand * operand * operand;
		return cube;
	}

	/*
	 * This method takes two doubles and returns the average.
	 */
	public static double average(double operand1, double operand2) {
		double average=(operand1 + operand2)/2;
		return average;
	}

	/*
	 * This method takes 3 doubles and returns the average.
	 */
	public static double average(double operand1, double operand2,double operand3) {
		double average=(operand1 + operand2 + operand3)/3;
		return average;
	}
    /*
     * This method converts an angle measure given in radians into degrees.
     */
     public static double toDegrees(double operand) {
    	double toDegrees=(operand * (180/3.14159));
    	return toDegrees;
     }
/*
 * toRadians
 */
     public static double toRadians(double operand) {
    	 double toRadians=(operand * (3.14159/180));
    	 return toRadians;
     }
}

	
