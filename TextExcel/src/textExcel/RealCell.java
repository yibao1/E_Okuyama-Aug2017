package textExcel;

public class RealCell implements Cell {
	private String text;

	public RealCell(String text) {
		this.setText(text);
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return getText();
	}

	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String spaces = "          ";
		String out = "" + getDoubleValue();
		if (out.length() < 10) {
			return out + spaces.substring(0, 10 - out.length());
		}
		return out.substring(0, 10);
	}

	public double getDoubleValue() {
		return Double.parseDouble(getText());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
