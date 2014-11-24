
public class StringCell extends Cell{
	
	String value;
	
	public StringCell(String newValue) {
		value = newValue;
	}
	
	public void setValue(String newValue) {
		value = newValue;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getDisplayableSpreadsheetValue() {
		String temp = value;
		if(temp.length() > 2 && temp.charAt(0) == '"' && temp.charAt(temp.length() -1) == '"') {
			temp = temp.substring(1, temp.length() - 1);
		}
		if(temp.length() > 12) {
			return temp.substring(0, 11) + ">";
		} else {
			return temp;
		}
		
	}
	
	public String getDisplayableSingleValue() {
		return value;
	}
	
	public static StringCell parseCell(String input) {
		if(input.charAt(0) != '"' || input.charAt(input.length() - 1) != '"') {
			return null;
		} 
		return new StringCell(input);
	}
}
