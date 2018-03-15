package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {

	Cell[][] excel;

	public String processCommand(String command)
	{
		return "";
		}

	public int getRows() {
		return 20;
	}

	public int getCols() {
		return 12;
	}

	public Cell getCell(Location loc) {
		return excel[loc.getRow()][loc.getCol()];
	}

	public String getGridText() {
		return ;
	}

}
