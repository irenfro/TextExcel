
public class CellParser {

	@SuppressWarnings("unused")
	public static Cell parseCell(String input) throws InvalidCellValueException {
		Cell cell = FormulaCell.parseCell(input);
		if (cell != null) {
			return cell;
		}
		cell = DoubleCell.parseCell(input);
		if(cell != null) {
			return cell;
		}
		cell = DateCell.parseCell(input);
		if(cell != null) {
			return cell;
		}
		cell = StringCell.parseCell(input);
		if (cell != null) {
			return cell;
		} else if(cell == null){
			return new StringCell("");
		}
		throw new InvalidCellValueException();
	}
	
	
	public static boolean isDouble(String input) {
		Cell cell = DoubleCell.parseCell(input);
		if(cell != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isDate(String input) {
		Cell cell = DateCell.parseCell(input);
		if(cell != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isString(String input) {
		Cell cell = StringCell.parseCell(input);
		if(cell != null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws InvalidCellValueException {
		Cell c = parseCell("\"I am string\"");
		System.out.println(c.getDisplayableSingleValue());
		c = parseCell("1.0");
		System.out.println(c.getDisplayableSingleValue());
		//c = parseCell("November/23/2014");
		//System.out.println(c.getDisplayableSingleValue());

	}
}
