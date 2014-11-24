
public class CellPrinter {
	
	public static void printUnpaddedCell(Cell c) {
		String value = c.getDisplayableSingleValue();
		if (value.equals(null) || value.equals("")) {
			System.out.println("<empty>");
		} else {
			System.out.println(value);
		}
	}

	public static void printPaddedCell(Cell c) {
		String v = c.getDisplayableSpreadsheetValue();
		if (v.length() > 12) {
			v = v.substring(0, 11) + ">";
		}
		int numOfSpacesRight = (12 - v.length()) / 2;
		int numOfSpacesLeft = 12 - v.length() - numOfSpacesRight;
		leadSpace(numOfSpacesLeft);
		System.out.print(v);
		leadSpace(numOfSpacesRight);
		System.out.print("|");

	}

	private static void leadSpace(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}
}
