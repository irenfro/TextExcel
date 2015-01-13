import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateCell extends Cell{
	
	String value;
	
	public DateCell(String newValue) {
		value = newValue;
	}
	
	public void setValue(String newValue) {
		value = newValue;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getDisplayableSpreadsheetValue() {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
			Date d;
			d = ft.parse(value);
			String text = ft.format(d);
			return text;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getDisplayableSingleValue() {
		return value;
	}
	
	public String getType() {
		return "[Date]";
	}
	
	public static DateCell parseCell(String input) {
		String pattern = "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)";
		if(input == null) {
			return null;
		}
		if(!input.matches(pattern)) {
			return null;
		} 
		return new DateCell(input);
	}
}
