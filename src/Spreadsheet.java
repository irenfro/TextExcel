public class Spreadsheet {
	final static int height = 10;
	final static int width = 7;
	Cell[][] data = new Cell[height + 1][width + 1];
	final static String line = "------------+";

	public Spreadsheet() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = new Cell();
			}
		}

		for (int i = 1; i < data[0].length; i++) {
			data[0][i] = new StringCell(Character.toString((char) (i - 1 + 'A')));
		}

		for (int i = 1; i < data.length; i++) {
			data[i][0] = new StringCell(Integer.toString(i) + " ");
		}
	}

	public void setValue(String location, String value) throws InvalidCellValueException {
		int[] coords = findLocation(location);
		data[coords[0]][coords[1]] = CellParser.parseCell(value);
	}

	public int[] findLocation(String location) {
		int[] coords = new int[2];
		coords[0] = Integer.parseInt(location.substring(1));
		coords[1] = location.charAt(0) - 'A' + 1;
		return coords;
	}

	public void printValue(String location) {
		int[] coords = findLocation(location);
		System.out.print(location + " = ");
		CellPrinter.printUnpaddedCell(data[coords[0]][coords[1]]);
	}

/*	public void clear() {
		for (int i = 1; i < data.length; i++) {
			for (int j = 1; j < data[0].length; j++) {
				data[i][j].setValue(null);
			}
		}
	}

	public void clear(String location) {
		int[] coords = findLocation(location);
		data[coords[0]][coords[1]].setValue(null);
	}*/ 

	public void print() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				CellPrinter.printPaddedCell(data[i][j]);
			}
			System.out.println();
			line();
		}
	}

	public void line() {
		for (int i = 0; i < data[0].length; i++) {
			System.out.print(line);
		}
		System.out.println();
	}

}
