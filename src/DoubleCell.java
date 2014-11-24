
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
	
	public String getDispValue() {
		String temp = Double.toString(value);
		if(temp.length() > 12) {
			return temp.substring(0, 11) + ">";
		} else {
			return temp;
		}
	}
	
	public static DoubleCell parseCell(String input) {
		try {
			return new DoubleCell(Double.parseDouble(input));
		} catch (Exception e) {
			return null;
		}	
	}
}
