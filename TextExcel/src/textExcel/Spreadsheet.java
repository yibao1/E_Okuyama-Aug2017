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
		if (lCommand.equals("clear")) {
			clear();
		} else if (lCommand.startsWith("clear")) {
			SpreadsheetLocation loc = new SpreadsheetLocation(command.split(" ")[1]);
			cells[loc.getRow()][loc.getCol()] = new EmptyCell();
		} else if (command.contains("=")) {
			String[] parts = command.split(" ", 3);
			SpreadsheetLocation loc = new SpreadsheetLocation(parts[0]);
			if (parts[2].endsWith("%")) {
				cells[loc.getRow()][loc.getCol()] = new PercentCell(parts[2].substring(0, parts[2].length() - 1));
			} else if (isNumeric(parts[2])){
				cells[loc.getRow()][loc.getCol()] = new ValueCell(parts[2]);
			} else if (parts[2].endsWith("\"")){
				cells[loc.getRow()][loc.getCol()] = new TextCell(parts[2].substring(1, parts[2].length() - 1));
			} else {
				cells[loc.getRow()][loc.getCol()] = new FormulaCell(parts[2]);
			}
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

	public String getGridText() {
		String output = "   |";
		String padding;
		for (int i = 0; i < getCols(); i++) {
			output += (char) (i + (int) 'A') + "         |";
		}
		output += "\n";
		for (int i = 0; i < getRows(); i++) {
			if (i < 9) {
				padding = "  ";
			} else {
				padding = " ";
			}
			output += (i + 1) + padding + "|";
			for (int j = 0; j < getCols(); j++) {
				output += cells[i][j].abbreviatedCellText() + "|";
			}
			output += "\n";
		}
		return output;
	}

	private void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	private static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!(Character.isDigit(c) || c == '.')) {
				return false;
			}
		}
		return true;
	}
}
