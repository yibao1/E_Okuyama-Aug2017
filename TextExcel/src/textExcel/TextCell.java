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
		String abbreviated;
		if (text.length() > 10) {
			abbreviated = text.substring(0, 10);
		} else {
			abbreviated = text;
			for (int i = text.length(); i <= 10 - 1; i++) {
				abbreviated += " ";
			}
		}
		return abbreviated;
	}
}
