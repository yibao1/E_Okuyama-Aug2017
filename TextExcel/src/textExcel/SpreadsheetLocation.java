/* Emi Okuyama
 * May 20th, 2018
 */
package textExcel;

public class SpreadsheetLocation implements Location {
	private String cellName;

	public SpreadsheetLocation(String cellName) {
		this.cellName = cellName.toUpperCase();
	}


	public int getRow() {
		return Integer.parseInt(this.cellName.substring(1))-1;
	}

	public int getCol() {
		char c = this.cellName.charAt(0);
		return (int)c - (int)'A';
	}

}
