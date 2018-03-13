package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public String fullCellText(){
		return "\"" + text + "\"";
	}

	@Override
	public String abbreviatedCellText() {
		String newText = text;
		while (newText.length() < 10) {
			newText += " ";
		}
		return newText;
	}
}
