
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


public class Test {

	public static final String EXAMPLE_TEST = "-1";
	
	public static void main(String[] args) throws ParseException {
		String input = "1/27/1996";
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyy");
		Date d = ft.parse(input);
		String text = ft.format(d);
		System.out.println(text);
	    
}

}
