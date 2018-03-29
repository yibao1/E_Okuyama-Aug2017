package textExcel;

public class FormulaCell extends RealCell {

	public FormulaCell(String text) {
		super(text);
	}

	// contains all the parsing and calculation logic required to generate a numeric
	// result for an arithmetic formula
	// that does not contain cell references.
	public double getDoubleValue() {
		String text = getText();
		String[] parts = text.substring(2, text.length() - 2).split(" ");
		double temp = Double.parseDouble(parts[0]);
		String operand = "";
		for(int i = 1; i < parts.length; i++) {
			if(i%2 == 0) {
				//it's a numeric value
				double num = Double.parseDouble(parts[i]);
				if(operand.equals("+")) {
					temp += num;
				} else if(operand.equals("-")) {
					temp -= num;
				} else if(operand.equals("*")) {
					temp *= num;
				} else if(operand.equals("/")) {
					temp /= num;
				}
				
			} else {
				//it's an operand
				operand = parts[i];
			}
		}
		return temp;
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
}
