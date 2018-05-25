/* Emi Okuyama
 * May 20th, 2018
 */

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

		if (lCommand.equals("")) {
			//do nothing for empty command
			return "";
		} else if (lCommand.equals("clear")) {
			// clearing the entire sheet (e.g., clear).
			clear();
		} else if (lCommand.startsWith("clear")) {
			// clearing a particular cell (e.g., clear A1).
			SpreadsheetLocation loc = new SpreadsheetLocation(command.split(" ")[1]);
			cells[loc.getRow()][loc.getCol()] = new EmptyCell();
		} else if (command.contains("=")) {
			// assignment of string values (e.g., A1 = "Hello").
			String[] parts = command.split(" ", 3);
			String rhs = parts[2];
			SpreadsheetLocation loc = new SpreadsheetLocation(parts[0]);
			int r = loc.getRow();
			int c = loc.getCol();
			if (rhs.endsWith("%")) {
				// Percent assignment (e.g. A1 = 5.2%)
				cells[r][c] = new PercentCell(rhs.substring(0, rhs.length() - 1));
			} else if (rhs.endsWith(")")) {
				cells[r][c] = new FormulaCell(rhs, this);
			} else if (rhs.endsWith("\"")) {
				cells[r][c] = new TextCell(rhs.substring(1, rhs.length() - 1));
			} else {
				// Real value assignment (e.g. A1 = 5.2)
				cells[r][c] = new ValueCell(rhs);
			}
		} else {
			// cell inspection (e.g., A1)
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
	
	public Cell getCell(int i, int j) {
		return this.cells[i][j];
	}
	
	// Return a single String containing the entire spreadsheet grid.
	public String getGridText() {
		String output = "   |";
		String padding;

		// Makes the columns
		for (int i = 0; i < getCols(); i++) {
			output += (char) (i + (int) 'A') + "         |";
		}
		output += "\n";

		// makes the rows
		for (int i = 0; i < getRows(); i++) {
			if (i < 9) {
				padding = "  ";

				// since double digits take more space use less spaces
			} else {
				padding = " ";
			}

			// adds spaces
			output += (i + 1) + padding + "|";

			// puts stuff in each cell
			for (int j = 0; j < getCols(); j++) {
				output += cells[i][j].abbreviatedCellText() + "|";
			}
			output += "\n";
		}
		return output;
	}

	// clears spreadsheet
	private void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}
}
