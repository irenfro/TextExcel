
public class FormulaCell extends Cell {
	
	String value;
	
	public FormulaCell(String newValue) {
		value = newValue;
	}
	
	public void setValue(String newValue) {
		value = newValue;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getType() {
		return "[Formula]";
	}
	
	public String getDisplayableSingleValue() {
		return value;
	}
	
	public String getDisplayableSpreadsheetValue() {
		return value;
	}
	
	public static FormulaCell parseCell(String input) {
		if(input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') {
			return new FormulaCell(input);
		} else {
			return null;
		}
	}

}
