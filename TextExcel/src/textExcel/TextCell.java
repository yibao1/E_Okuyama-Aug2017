package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	public String fullCellText(){
		return "\"" + text + "\"";
	}

	public String abbreviatedCellText() {
		String spaces = "          ";
		if(text.length() < 10) {
			return text + spaces.substring(0, 10 - text.length());
		}
		return text.substring(0, 10);
	}
}
