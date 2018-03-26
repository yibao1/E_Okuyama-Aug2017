package textExcel;

public class RealCell implements Cell {

	private String num;

	public RealCell(String num) {
		this.num = num;
	}

	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String spaces = "          ";
		if(num.length() < 10) {
			return num + spaces.substring(0, 10 - num.length());
		}
		return num.substring(0, 10);
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return num;
	}

}
