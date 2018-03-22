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
		int row, column;
 		String returnString = "";
 		if (command.contains("=")){
 			String[] data = command.split(" ", 3);
 			SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
 			if (isNumeric(data[2])) {
 								ValueCell valueCell = new ValueCell(data[2]);
 								excel[location.getRow() + 1][location.getCol() + 1] = valueCell;	
 								return getGridText();
 							}
 							if (data[2].contains("%")) {
 								PercentCell percentCell = new PercentCell(data[2]);
 								excel[location.getRow() + 1][location.getCol() + 1] = percentCell;	
 								return getGridText();
 							}
 							if(!data[2].substring(0,1).equals("\"") && (command.contains("+") || command.contains("-") || command.contains("*") || command.contains("/"))) {
 								FormulaCell formulaCell = new FormulaCell(data[2]);
 								excel[location.getRow() + 1][location.getCol() + 1] = formulaCell;
 								return getGridText();
 							}
 							String [] contentsWithoutQuotes = data[2].split("\"", 3);
 							TextCell text = new TextCell(contentsWithoutQuotes[1]);
 							excel[location.getRow()+1][location.getCol()+1]= text;
 				 			return getGridText();
 				 		}
 				 		if (command.length() <= 3 && command.length() != 0) {
 				 			SpreadsheetLocation location = new SpreadsheetLocation(command);
 				 			return excel[location.getRow()+1][location.getCol()+1].fullCellText();
 				 		}
 				 		if (command.toLowerCase().contains("clear ")) {
 				 						String [] splitInput2 = command.split(" ", 2);
 				 						SpreadsheetLocation location = new SpreadsheetLocation(splitInput2[1]);
 				 						excel[location.getRow() + 1][location.getCol() + 1] = new EmptyCell();
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
