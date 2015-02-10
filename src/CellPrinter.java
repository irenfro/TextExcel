



public class CellPrinter {
	
	
	public static void printUnpaddedCell(Cell c) {
		String value = c.getDisplayableSingleValue();
		if (value.equals(null) || value.equals("")) {
			System.out.println("<empty>");
		} else {
			System.out.println(value);
			System.out.println("\n" + c.getType());
		}
	}

	public static void printPaddedCell(Cell c) throws InvalidInputException {
		String v = c.getDisplayableSpreadsheetValue();
		
		if(v.length() > 12 && (c.getType().equals("[Number]") || c.getType().equals("[Formula]"))) {
			double d = Double.parseDouble(v);
			String s = String.format("%.6g", d);
			formatAndPrint(s);
		} else {
			formatAndPrint(v);
		}

	}
	
	public static void formatAndPrint(String s) {
		if (s.length() > 12) {
			s = s.substring(0, 11) + ">";
		}
		int numOfSpacesRight = (12 - s.length()) / 2;
		int numOfSpacesLeft = 12 - s.length() - numOfSpacesRight;
		leadSpace(numOfSpacesLeft);
		System.out.print(s);
		leadSpace(numOfSpacesRight);
		System.out.print("|");
	}

	private static void leadSpace(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}
}

