
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
	
	

}
