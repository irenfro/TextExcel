public class Cell {

	public Cell() {
	}
	
	public String getDisplayableSpreadsheetValue() {
		return "";
	}
	
	public String getDisplayableSingleValue() {
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
}