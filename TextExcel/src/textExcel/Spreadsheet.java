package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {

	Cell[][] excel;

	public Spreadsheet() {
		excel = new Cell[getCols()][getRows()];
		reset();
	}
	
	public String processCommand(String command)
	{
		String[] parsed = command.split(" ", 3);
		if(parsed.length == 1) {
			if (Character.isAlphabetic(Character.toLowerCase(command.charAt(0))) && Character.isDigit(command.charAt(1))) {
				Location thisCell = new SpreadsheetLocation(command);
				return getCell(thisCell).fullCellText();
			} else if (command.toLowerCase().equals("clear")) {
				reset();
				return getGridText();
			}
		} else if (parsed.length == 2) {
			if (command.toLowerCase().startsWith("clear")) {
				Location thisCell = new SpreadsheetLocation(parsed[1]);
				excel[thisCell.getCol()][thisCell.getRow()] = new EmptyCell(); // check this out
				return getGridText();
			}
		} else {
			if (Character.isAlphabetic(Character.toLowerCase(command.charAt(0))) && Character.isDigit(command.charAt(1))) {
				if (parsed[1].equals("=")) {
					if (parsed[2].startsWith("" + '"')) {
						Location thisCell = new SpreadsheetLocation(parsed[0].toLowerCase());
						String input = parsed[2].substring(1, (parsed[2].length() - 1));
						excel[thisCell.getCol()][thisCell.getRow()] = new TextCell(input); //check this out
						return getGridText();
					}
				}
			}
		}
		return "TEST";
		}

	public int getRows() {
		return 20;
	}

	public int getCols() {
		return 12;
	}

	public Cell getCell(Location loc) {
		return excel[loc.getCol()][loc.getRow()];
	}

	public String getGridText() {
String output = "   ";
		
		for (int i = 0; i < excel.length; i++) {
			output = output + "|" + ((char)(65 + i)) + "         ";
		}
		output += "|\n";
		for (int r = 0; r < excel[0].length; r++) {
			String rowNumber = "" + (r + 1);
			while (rowNumber.length() < 3) {
				rowNumber += " ";
			}
			output += rowNumber;
			for (int c = 0; c < excel.length; c++) {
				output = output + "|" + excel[c][r].abbreviatedCellText();
			}
			output += "|";
		output += "\n";
		}
		
		return output;
	}
	
	private void reset() {
		for (int r = 0; r < excel[0].length; r++) {
			for (int c = 0; c < excel.length; c++) {
				excel[c][r] = new EmptyCell();
			}
		}
	}

}
