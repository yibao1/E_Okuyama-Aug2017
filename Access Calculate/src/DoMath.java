/* Emi Okuyama
 * September 5th, 2017
 * This is the runner class for my Calculate Library methods.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(2));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(2, 6));
		System.out.println(Calculate.average(3,3,3));
		System.out.println(Calculate.toDegrees(3.14159));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(2,1,1));
		System.out.println(Calculate.toImproperFrac(2, 1, 2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2,3,6,-7,"n"));
		System.out.println(Calculate.isDivisibleBy(6, 2));
		System.out.println(Calculate.absValue(-1.0));
		System.out.println(Calculate.max(2,3));
		System.out.println(Calculate.max(1,2,3));
		System.out.println(Calculate.max(3,2,1));
		System.out.println(Calculate.max(1,3,2));
		System.out.println(Calculate.min(2,3));
		System.out.println(Calculate.round2(1.114));
		System.out.println(Calculate.round2(1.995));
	}

}
