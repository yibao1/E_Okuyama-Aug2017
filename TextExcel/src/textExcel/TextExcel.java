package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Scanner;
// Update this file with your own code.

public class TextExcel
{
	public static Spreadsheet sheet1 = new Spreadsheet();
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
	    String userIn;
	    
	    while (true) {
	    		userIn = myScanner.nextLine();
	    		System.out.println(sheet1.processCommand(userIn));
	}
}
}