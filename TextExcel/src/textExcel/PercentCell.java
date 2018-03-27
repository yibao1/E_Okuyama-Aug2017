package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String text) {
		super(text);
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "" + getDoubleValue();
	}

	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String spaces = "          ";
		
		//truncates the number
		String out = "" + (int) (getDoubleValue() * 100);
		
		//adds spaces
		if (out.length() < 9) {
			out += "%" + spaces.substring(0, 9 - out.length());
		} else {
			out = out.substring(0, 9) + "%";
		}
		return out;
	}

	//returns the calculated value of the cell as a double (not a String).
	public double getDoubleValue() {
		return Double.parseDouble(getText()) / 100;
	}
}
