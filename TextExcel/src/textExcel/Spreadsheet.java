package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] cells;
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	public String processCommand(String command) {
		return "";
	}

	public int getRows() {
		return 20;
	}

	public int getCols() {
		return 12;
	}

	public Cell getCell(Location loc) {
		Cell c = new EmptyCell();
		return c; 
	}

	public String getGridText() {
		return "foo";
	}

	private void reset() {
	}

}
