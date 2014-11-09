
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
		if(value == null) {
			System.out.print("            ");
			return;
		}
		if(value.length() < 11) {
			int numOfSpaces = (12 - value.length()) / 2;
			leadSpace(numOfSpaces);	
			System.out.print(value);		
			if(value.length() % 2 == 1) {
				leadSpace(numOfSpaces + 1);
			} else {
				leadSpace(numOfSpaces);
			}				
		} else if(value.length() == 11) {
			System.out.print(value + " ");
		} else {
			System.out.print(value.substring(0, 11) + ">");
		}
	}
	
	public static void leadSpace(int x) {
		for(int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}
}
