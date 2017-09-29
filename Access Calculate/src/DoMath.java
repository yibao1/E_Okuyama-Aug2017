/* Emi Okuyama
 * September 5th, 2017
 * This is the runner class for my Calculate Library methods.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println("square(2)               = " + Calculate.square(2));
		System.out.println("cube(2)                 = " + Calculate.cube(2));
		System.out.println("average(2, 6)           = " + Calculate.average(2, 6));
		System.out.println("average(3,3,3)          = " + Calculate.average(3, 3, 3));
		System.out.println("toDegrees(3.14159)      = " + Calculate.toDegrees(3.14159));
		System.out.println("toRadians(180)          = " + Calculate.toRadians(180));
		System.out.println("discriminant(2,1,1)     = " + Calculate.discriminant(2, 1, 1));
		System.out.println("toImproperFrac(2, 1, 2) = " + Calculate.toImproperFrac(2, 1, 2));
		System.out.println("toMixedNum(7,2)         = " + Calculate.toMixedNum(7, 2));
		System.out.println("foil(2,3,6,-7,n)        = " + Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println("isDivisibleBy(6, 2)     = " + Calculate.isDivisibleBy(6, 2));
		System.out.println("absValue(-1.0)          = " + Calculate.absValue(-1.0));
		System.out.println("max(2,3)                = " + Calculate.max(2, 3));
		System.out.println("max(1,2,3)              = " + Calculate.max(1, 2, 3));
		System.out.println("max(3,2,1)              = " + Calculate.max(3, 2, 1));
		System.out.println("max(1,3,2)              = " + Calculate.max(1, 3, 2));
		System.out.println("min(2,3)                = " + Calculate.min(2, 3));
		System.out.println("round2(1.114)           = " + Calculate.round2(1.114));
		System.out.println("round2(1.995)           = " + Calculate.round2(1.995));
		System.out.println("exponent(2.0,0)         = " + Calculate.exponent(2.0, 0));
		System.out.println("exponent(2.0,3)         = " + Calculate.exponent(2.0, 3));
		System.out.println("factorial(0)            = " + Calculate.factorial(0));
		System.out.println("factorial(5)            = " + Calculate.factorial(5));
		System.out.println("isPrime(8)              = " + Calculate.isPrime(8));
		System.out.println("isPrime(13)             = " + Calculate.isPrime(13));
		System.out.println("gcf(6,12)               = " + Calculate.gcf(6, 12));
		System.out.println("gcf(12,6)               = " + Calculate.gcf(12, 6));
		System.out.println("gcf(13,17)              = " + Calculate.gcf(13, 17));
		System.out.println("gcf(3,5)                = " + Calculate.gcf(3, 5));
		System.out.println("sqrt(105.0)             = " + Calculate.sqrt(105.0));
		System.out.println("quadForm(5, 2, 6)       = " + Calculate.quadForm(5, 2, 6));
		System.out.println("quadForm(1, 4, 4)       = " + Calculate.quadForm(1, 4, 4));
		System.out.println("quadForm(1, 0, -1)      = " + Calculate.quadForm(1, 0, -1));
		System.out.println("exceptions");
		// System.out.println(Calculate.factorial(-1));
		// System.out.println(Calculate.exponent(2.0,-2));
		// System.out.println(Calculate.isDivisibleBy(6, 0));
		// System.out.println(Calculate.sqrt(-105.0));
	}

}
