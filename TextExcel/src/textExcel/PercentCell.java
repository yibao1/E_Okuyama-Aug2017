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
		String out = "" + (int) (getDoubleValue() * 100);
		if (out.length() < 9) {
			out += "%" + spaces.substring(0, 9 - out.length());
		} else {
			out = out.substring(0, 9) + "%";
		}
		return out;
	}

	public double getDoubleValue() {
		return Double.parseDouble(getText()) / 100;
	}
}
