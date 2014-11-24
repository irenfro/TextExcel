public class Cell {

	public Cell() {
	}

	public void printPaddedCell() {
		printValue();
		System.out.print("|");
	}

	public void printValue() {
		String v = this.getDisplayableSpreadsheetValue();
		if (v.length() > 12) {
			v = v.substring(0, 11) + ">";
		}
		int numOfSpacesRight = (12 - v.length()) / 2;
		int numOfSpacesLeft = 12 - v.length() - numOfSpacesRight;
		leadSpace(numOfSpacesLeft);
		System.out.print(v);
		leadSpace(numOfSpacesRight);
	}

	public static void leadSpace(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}

	public void printUnpaddedCell() {
		String value = this.getDisplayableSingleValue();
		if (value.equals(null) || value.equals("")) {
			System.out.println("<empty>");
		} else {
			System.out.println(value);
		}
	}
	
	public String getDisplayableSpreadsheetValue() {
		return "";
	}
	
	public static Cell parseCell(String input) throws InvalidCellValueException {
		Cell cell = DoubleCell.parseCell(input);
		if (cell != null) {
			return cell;
		}
		cell = StringCell.parseCell(input);
		if (cell != null) {
			return cell;
		}
		throw new InvalidCellValueException();
	}
	
	public String getDisplayableSingleValue() {
		return "";
	}
	
	
}