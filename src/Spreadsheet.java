
public class Spreadsheet {
	final static int height = 10;
	final static int width = 7;
	Cell[][] data = new Cell[height][width];
	final static String line = "------------+";

	public Spreadsheet() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				data[i][j] = new Cell();
			}
		}
	}
	
	public void print() {
		printHeaderRow();
		for(int i = 0; i < data.length; i++) {
			printRowLable(i + 1);
			for(int j = 0; j < data[i].length; j++) {
				data[i][j].print();
			}
			System.out.println();
			line();
		}
	}
	
	public void printHeaderRow() {
		Cell c = new Cell();
		c.print();
		for(int i = 0; i < data[0].length; i++) {
			c.setValue(Character.toString((char)(i + 'A')));
			c.print();
		}
		System.out.println();
		line();
	}
	
	public static void printRowLable(int i) {
		Cell c = new Cell();
		c.setValue(Integer.toString(i));
		c.print();
	}
	
	public void line() {
		for(int i = 0; i <= data[0].length; i++) {
			System.out.print(line);
		}
		System.out.println();
	}
}
