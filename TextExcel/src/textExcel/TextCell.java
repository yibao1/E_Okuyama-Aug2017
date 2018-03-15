package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public String fullCellText(){
		return "\"" + text + "\"";
	}

	public String abbreviatedCellText() {
		String newText = text;
		while (newText.length() < 10) {
			newText += " ";
		}
		return newText;
	}
}
