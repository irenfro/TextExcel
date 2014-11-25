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
		return value;
	}
	
	public String getDisplayableSingleValue() {
		return "\"" + value + "\"";
	}
	
	public static StringCell parseCell(String input) {
		if(input.length() < 2 || 
		   input.charAt(0) != '"' || 
		   input.charAt(input.length() - 1) != '"'){
			return null;
		} 
		return new StringCell(input.substring(1, input.length() - 1));
	}
}
