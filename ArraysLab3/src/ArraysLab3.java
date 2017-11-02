
public class ArraysLab3 {
	public static void main(String[] args) {
		int arr1[] = new int[];
		System.out.println(ArraysLab3.sum(arr1, arr2));
	}

	public static int[] sum(int[] arr1, int[] arr2) {
		int sumArray[] = new int[arr1.length];
		for (int i = 0; i <= sumArray.length; i++) {
			sumArray[i] = arr1[i] + arr2[i];
		}
		return sumArray;
	}
}
