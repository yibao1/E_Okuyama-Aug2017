/*
 * Emi Okuyama
 * November 1st, 2017
 * Arrays Mini Lab
 */
import java.util.Arrays;

public class LotsofCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = { 1, 2, 3, 4, 5 };

		/*
		 * When I passed something into changeMe and then changed the value inside
		 * changeMe the value did not change in the main part of my program unless it was an array.
		 */

		System.out.println("== part 1 ==");
		System.out.println("before: ");
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		changeMe(num, strMain, arrMain);
		System.out.println("after: ");
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));

		/*
		 * When I set one variable to equal another and then change the original
		 * variable to something else, the second variable stays the same unless its an array.
		 */

		System.out.println("\n== part 2 ==");
		System.out.println("before:");
		int aInt = 1;
		String aString = "foo";
		int[] aArray = { 1, 2, 3, 4, 5 };
		int bInt = aInt;
		String bString = aString;
		int[] bArray = aArray;
		System.out.println(bInt);
		System.out.println(bString);
		System.out.println(Arrays.toString(bArray));
		System.out.println("after: ");
		aInt = 2;
		aString = "bar";
		for (int i = 0; i < aArray.length; i++) {
		aArray[i]++;
		}
		System.out.println(bInt);
		System.out.println(bString);
		System.out.println(Arrays.toString(bArray));
	}

	public static void changeMe(int x, String str, int[] arr) {
		x = 1;
		str = "hi";
		for (int i = 0; i < arr.length; i++) {
		arr[i] ++;
	}
		System.out.println("inside changeMe: ");
		System.out.println(x);
		System.out.println(str);
		System.out.println(Arrays.toString(arr));
	}

}
