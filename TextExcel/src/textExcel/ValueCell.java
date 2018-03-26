package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String num) {
		super(num);
	}

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
