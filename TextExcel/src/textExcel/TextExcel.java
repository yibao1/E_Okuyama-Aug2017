/* Emi Okuyama
 * May 20th, 2018
 */
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {
	public static void main(String[] args) {
		Scanner commandInput = new Scanner(System.in);
		Spreadsheet spreadsheet = new Spreadsheet();
		while (true) {
			String nextCommand = commandInput.nextLine();
			if (nextCommand.equals("quit")) {
				return;
			} else {
				// System.out.println(spreadsheet.processCommand(nextCommand));
			}
		}
	}
}