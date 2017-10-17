
/* Emi Okuyama
 * October 10th, 2017
 * This is a program that can describe the graph of a quadratic function.
 */
import java.util.*;

public class QuadraticClient {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Provide values for coefficients a, b, and c");
			System.out.print("a: ");
			double a = scanner.nextDouble();
			System.out.print("b: ");
			double b = scanner.nextDouble();
			System.out.print("c: ");
			double c = scanner.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("\nDo you want to keep going? (type \"quit\" to end)");
			String finished = scanner.next();
			if (finished.equals("quit")) {
				done = true;
			}
		}
		scanner.close();
	}
}