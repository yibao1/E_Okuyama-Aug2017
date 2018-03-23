package textExcel;

public class SpreadsheetLocation implements Location {
	private String cellName;

	public SpreadsheetLocation(String cellName) {
		this.cellName = cellName;
	}

	@Override
	public int getRow() {
		return Integer.parseInt(this.cellName.substring(1))-1;
	}

	@Override
	public int getCol() {
		char c = this.cellName.charAt(0);
		return (int)c - (int)'A';
	}

}
