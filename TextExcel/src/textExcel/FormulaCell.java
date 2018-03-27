package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String text) {
		super(text);
	}

	//contains all the parsing and calculation logic required to generate a numeric result for an arithmetic formula 
	//that does not contain cell references.
	public double getDoubleValue() {
		String[] parts = getText().split(" ");
		double num;
		if(parts[1].equals("*")) {
			num = Double.parseDouble(parts[0]) * Double.parseDouble(parts[2]);
		}
	}
}
