



public class CellMatrix {
	final static int height = 10;
	final static int width = 7;
	Cell[][] data = new Cell[height + 1][width + 1];
	final static String line = "------------+";

	public CellMatrix() {
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
		if(coords[0] > 10 || coords[1] > 7) {
			System.out.println("Error: The cell that you requested is not within the vaild cells.  \nValid cells are A-G x 1-10");
			return; 
		}
		data[coords[0]][coords[1]] = CellParser.parseCell(value);
	}
	
	public void setValue(int row, String rowValue) throws InvalidCellValueException {
		String[] singleValues = rowValue.split("Ω");
		for(int i = 0; i < singleValues.length; i++) {
			data[row][i] = CellParser.parseCell(singleValues[i]);
		}
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
	
	public void print() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				try {
					CellPrinter.printPaddedCell(data[i][j]);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public Cell getCell(String location) {
		int[] coords = findLocation(location);
		return data[coords[0]][coords[1]];
	}

	public void clear() throws InvalidCellValueException {
		for (int i = 1; i < data.length; i++) {
			for (int j = 1; j < data[0].length; j++) {
				data[i][j] = CellParser.parseCell(null);
			}
		}
	}

	public void clear(String location) throws InvalidCellValueException {
		int[] coords = findLocation(location);
		data[coords[0]][coords[1]] = CellParser.parseCell(null);
	} 

	public String[] getSaveData() {
		String[] saveRows = new String[height+1];
		int posSaveRows = 0;
		for(int i = 0; i < this.height+1; i++) {
			String row = "";
			for(int j = 0; j < this.width+1; j++) {
				String temp = data[i][j].getDisplayableSingleValue() + "Ω";
				if(temp.equals("Ω")){
					temp = "\"\"Ω";
				}
				row += temp;
			}
			saveRows[posSaveRows] = row;
			posSaveRows++;
		}
		return saveRows;
	}

	public void loadFrom(String[] array) throws InvalidCellValueException {
		for(int i = 0; i < array.length; i++) {
			setValue(i, array[i]);
		}
	}

	

}
