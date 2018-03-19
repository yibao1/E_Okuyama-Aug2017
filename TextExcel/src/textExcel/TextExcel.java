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
		Scanner commandInput = new Scanner(System.in);
	    Spreadsheet spreadsheet = new Spreadsheet();
	    boolean contin = true;
	    while (contin) {
	    	String nextCommand = commandInput.nextLine();
	    	if (nextCommand.equals("quit")) {
	    		contin = false;
	    	} else {
	    		System.out.println(spreadsheet.processCommand(nextCommand));
	    	}
	    }
}
}