/* Emi Okuyama
 * May 20th, 2018
 */
package textExcel;

public class FormulaCell extends RealCell {

	private Spreadsheet sheet;
	private String original;

	public FormulaCell(String text, Spreadsheet sheet) {
		super(text.toUpperCase());
		this.sheet = sheet;
		original = text;
	}

	// contains all the parsing and calculation logic required to generate a numeric
	// result for an arithmetic formula
	// that does not contain cell references.
	public double getDoubleValue() {
		String text = getText();
		String[] parts = text.substring(2, text.length() - 2).split(" ");
		if (parts[0].equals("AVG") || parts[0].equals("SUM")) {
			double sum = 0;
			int count = 0;
			String[] range = parts[1].split("-");
			SpreadsheetLocation start = new SpreadsheetLocation(range[0]);
			SpreadsheetLocation end = new SpreadsheetLocation(range[1]);
			for(int i = start.getRow(); i <= end.getRow(); i++) {
				for(int j = start.getCol(); j <= end.getCol(); j++) {
					sum += sheet.getCell(i,j).getDoubleValue();
					count++;
				}
			}
			if (parts[0].equals("AVG")) {
				return sum / count;
			}
			return sum;
		} else {
			double temp = parseValue(parts[0]);
			String operand = "";
			for (int i = 1; i < parts.length; i++) {
				if (i % 2 == 0) {
					// it's a numeric value
					double num = parseValue(parts[i]);
					if (operand.equals("+")) {
						temp += num;
					} else if (operand.equals("-")) {
						temp -= num;
					} else if (operand.equals("*")) {
						temp *= num;
					} else if (operand.equals("/")) {
						temp /= num;
					}

				} else {
					// it's an operand
					operand = parts[i];
				}
			}
			return temp;
		}
	}

	private double parseValue(String value) {
		if (value.charAt(0) >= 'A' && value.charAt(0) <= 'Z') {
			SpreadsheetLocation loc = new SpreadsheetLocation(value);
			return sheet.getCell(loc).getDoubleValue();
		} else {
			return Double.parseDouble(value);
		}
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return original;
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
