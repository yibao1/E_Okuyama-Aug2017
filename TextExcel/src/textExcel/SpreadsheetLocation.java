package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
private String cellName;
	
    @Override
    public int getRow() {
        String number = cellName.substring(1,cellName.length());
        int row = 0;
        while (!(number.equals("" + row))) {
        	row++;
        }
    	return row - 1;
    }

    @Override
    public int getCol()
    {
        char letter = cellName.charAt(0);
        letter = Character.toLowerCase(letter);
        return Character.getNumericValue(letter) - Character.getNumericValue('a');
        
        
    }
    
    public SpreadsheetLocation(String cellName) {
        this.cellName = cellName.toLowerCase();
    }

}
