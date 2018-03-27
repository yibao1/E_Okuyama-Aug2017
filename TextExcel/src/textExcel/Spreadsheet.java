package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] cells;

	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		clear();
	}

	public String processCommand(String command) {
		String lCommand = command.toLowerCase();
		
		//clearing the entire sheet (e.g., clear).
		if (lCommand.equals("clear")) {
			clear();
	
		//clearing a particular cell (e.g., clear A1).
		} else if (lCommand.startsWith("clear")) {
			SpreadsheetLocation loc = new SpreadsheetLocation(command.split(" ")[1]);
			cells[loc.getRow()][loc.getCol()] = new EmptyCell();
		
		//assignment of string values (e.g., A1 = “Hello”).
		} else if (command.contains("=")) {
			String[] parts = command.split(" ", 3);
			SpreadsheetLocation loc = new SpreadsheetLocation(parts[0]);
			
			//Percent assignment (e.g. A1 = 5.2%)
			if (parts[2].endsWith("%")) {
				cells[loc.getRow()][loc.getCol()] = new PercentCell(parts[2].substring(0, parts[2].length() - 1));
			
			//Real value assignment (e.g. A1 = 5.2, or A1 = (A2 + A3 * 4),
			} else if (isNumeric(parts[2])){
				cells[loc.getRow()][loc.getCol()] = new ValueCell(parts[2]);
			
			} else if (parts[2].endsWith("\"")){
				cells[loc.getRow()][loc.getCol()] = new TextCell(parts[2].substring(1, parts[2].length() - 1));
			} else {
				cells[loc.getRow()][loc.getCol()] = new FormulaCell(parts[2]);
			}
		
		//cell inspection (e.g., A1)
		} else {
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return cells[loc.getRow()][loc.getCol()].fullCellText();
		}
		return getGridText();
	}

	public int getRows() {
		return 20;
	}

	public int getCols() {
		return 12;
	}

	public Cell getCell(Location loc) {
		return this.cells[loc.getRow()][loc.getCol()];
	}

	//Return a single String containing the entire spreadsheet grid.
	public String getGridText() {
		String output = "   |";
		String padding;
		
		//Makes the columns 
		for (int i = 0; i < getCols(); i++) {
			output += (char) (i + (int) 'A') + "         |";
		}
		output += "\n";
		
		//makes the rows
		for (int i = 0; i < getRows(); i++) {
			if (i < 9) {
				padding = "  ";
			
			//since double digits take more space use less spaces
			} else {
				padding = " ";
			}
			
			//adds spaces
			output += (i + 1) + padding + "|";
			
			//puts stuff in each cell
			for (int j = 0; j < getCols(); j++) {
				output += cells[i][j].abbreviatedCellText() + "|";
			}
			output += "\n";
		}
		return output;
	}

	//clears spreadsheet
	private void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	//checks if string is numeric
	private static boolean isNumeric(String str) { 
		for (char c : str.toCharArray()) {
			if (!(Character.isDigit(c) || c == '.')) {
				return false;
			}
		}
		return true;
	}
}
