
import java.util.regex.Pattern;


public class Test {

	public static final String EXAMPLE_TEST = "-1";
	
	public static void main(String[] args) {
		
		System.out.println(EXAMPLE_TEST.matches("^-?([0-9]+.?[0-9]*|[0-9]*.[0-9]+)$"));
		System.out.println(Double.parseDouble(EXAMPLE_TEST));
	    
}

}
