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
			if(!num.contains(".")) {
				return num + ".0" + spaces.substring(0, 8 - num.length());
			}else if(num.endsWith("0")) {
				String num1 = num.substring(0, num.lastIndexOf("0"));
				return num1 + spaces.substring(0, 10 - num1.length());
			}
			return num + spaces.substring(0, 10 - num.length());
		}
		return num.substring(0, 10);
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return num;
	}

}
