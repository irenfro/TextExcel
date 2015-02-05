public class Cell {
	String value;
	
	public Cell() {
	}
	
	public String getDisplayableSpreadsheetValue() throws InvalidInputException {
		return "";
	}
	
	public String getDisplayableSingleValue() {
		return "";
	}

	public String getType() {
		return "";
	}

	public String getValue() {
		return null;
	}
	
	public double getNumericValue() throws InvalidInputException {
		throw new InvalidInputException("numeric value not supported");
	}
}