
/*
 * Emi Okuyama
 * November 4th, 2017
 * This is a lab about arrays
 */
import java.util.Arrays;

public class ArraysLab3 {
	public static void main(String[] args) {
		int a1[] = { 5, 10, 15, 20, 25, 30, 35, 40 };
		int a2[] = { 7, 14, 21, 28, 35, 42, 49, 56 };
		int sumArr[] = ArraysLab3.sum(a1, a2);
		int appendNum = 200;
		int appendArr[] = ArraysLab3.append(a1, appendNum);
		int removeIdx = 5;
		int removeArr[] = ArraysLab3.remove(a2, removeIdx);
		int sumOfEvens = ArraysLab3.sumEven(appendArr);
		ArraysLab3.rotateRight(a1);

		System.out.println("sumArr: " + Arrays.toString(sumArr));
		System.out.println("appendArr: " + Arrays.toString(appendArr));
		System.out.println("removeArr: " + Arrays.toString(removeArr));
		System.out.println("sumOfEvens: " + sumOfEvens);
		System.out.println("rotateRight: " + Arrays.toString(a1));
	}

	public static int[] sum(int[] arr1, int[] arr2) {
		int sumArray[] = new int[arr1.length]; // array length is the same as the inputed arrays
		for (int i = 0; i < sumArray.length; i++) {
			sumArray[i] = arr1[i] + arr2[i]; // add the arrays at the same index
		}
		return sumArray;
	}

	public static int[] append(int[] arr, int num) {
		int appendArray[] = new int[arr.length + 1]; // array length is increased by one
		for (int i = 0; i < arr.length; i++) {
			appendArray[i] = arr[i]; // copies array till new array length
		}
		appendArray[arr.length] = num; // adds new number into the array
		return appendArray;
	}

	public static int[] remove(int[] arr, int idx) {
		int removeArray[] = new int[arr.length - 1]; // array length is decreased by one
		for (int i = 0; i < idx; i++) { // copies array until certain index
			removeArray[i] = arr[i];
		}
		for (int j = idx; j < arr.length; j++) { // copies array after certain index and places it one index back
			removeArray[j - 1] = arr[j];
		}
		return removeArray;
	}

	public static int sumEven(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) { // tests whether the numbers in array are even
				sum = sum + arr[i]; // adds array to sum
			}
		}
		return sum;
	}

	public static void rotateRight(int[] arr) {
		int last = arr[arr.length - 1]; // declares last number of array into a temp variable
		for (int i = arr.length - 1; i > 0; i--) { // shifts array one to the right
			arr[i] = arr[i - 1];
		}
		arr[0] = last; // places last number at index 0
	}
}
