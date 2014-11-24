
public class DoubleCell extends Cell{

	double value;
	
	public DoubleCell(double newValue) {
		value = newValue;
	}
	
	public void setValue(double newValue) {
		value = newValue;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getDisplayableSpreadsheetValue() {
		String stringValue = Double.toString(value);
		if(stringValue.length() > 12) {
			return stringValue.substring(0, 11) + ">";
		} else {
			return stringValue;
		}
	}
	
	public String getDisplayableSingleValue() {
		long wholeNumber = (int) value;
		if(wholeNumber == value) {
			return Long.toString(wholeNumber);
		}
		return Double.toString(value);
	}
	
	public static DoubleCell parseCell(String input) {
		try {
			return new DoubleCell(Double.parseDouble(input));
		} catch (Exception e) {
			return null;
		}	
	}
}
