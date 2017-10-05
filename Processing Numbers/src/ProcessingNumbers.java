
/*
 * Emi Okuyama
 * October 3rd 2017
 * This is a program that processes numbers using a scanner
 */
import java.util.*;

public class ProcessingNumbers {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many numbers do you want to add? ");
		int totalNumber = scanner.nextInt();
		int sum = 0;
		int min = 0;
		int max = 0;
		int maxEven = 0; 
		boolean minSet = false;
		boolean maxSet = false;
		boolean maxEvenSet = false;
		for (int i = 0; i < totalNumber; i++) {
			System.out.print("#" + i + "? ");
			int next = scanner.nextInt();
					
			if(next % 2 == 0) {
				sum += next;
				if(!maxEvenSet || next > maxEven) {
					maxEvenSet = true;
					maxEven = next;
				}
			}
			if(!minSet || next < min) {
				minSet = true;
				min = next;
			}
			if(!maxSet || next > max) {
				maxSet = true;
				max = next;
			}
		}
		System.out.print("Smallest number = ");
		if(minSet) {
			System.out.println(min);
		} else {
			System.out.println("No min value");
		}
		System.out.print("Largest number = ");
		if(maxSet) {
			System.out.println(max);
		} else {
			System.out.println("No max value");
		}
		System.out.println("Sum of even numbers = " + sum);
		System.out.print("Largest even number = ");
		if(maxEvenSet) {
			System.out.println(maxEven);
		} else {
			System.out.println("No max even value");
		}
	}
}