
public class Cell {
	
	String value;

	public Cell() {
		
	}
	
	public Cell(String newValue) {
		value = newValue;
	}
	
	public String setValue(String newValue) {
		value = newValue;
		return value;
	}
	
	public void print() {
		printValue();
		System.out.print("|");
	}
	public void printValue() {
		String v = value;
		if(v == null) {
			v = "";
		}
		if(v.matches("^-?([0-9]+.?[0-9]*|[0-9]*.[0-9]+)$ (?!\\s)")) {
			v = Double.toString(Double.parseDouble(value));
		}

		if(v.length() < 12) {
			int numOfSpacesRight = (12 - v.length()) / 2;
			int numOfSpacesLeft = 12 - v.length() - numOfSpacesRight;
			leadSpace(numOfSpacesLeft);
			
			System.out.print(v);		
			leadSpace(numOfSpacesRight);
							
		} else {
			System.out.print(v.substring(0, 11) + ">");
		}
	}
	
	public static void leadSpace(int x) {
		for(int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}
	
	public void print(String s) {
		if(value == null) {
			System.out.println("<empty>");
		} else {
			printValue();
		}
	}
}
