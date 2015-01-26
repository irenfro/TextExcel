import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Test {
	
	public static void main(String[] args) throws InvalidInputException {
		List<String> tokens = Tokenize.tokenize("A1 = (1*2)");
		for(int i = 0; i < tokens.size(); i++) {
			System.out.println(tokens.get(i));
		}
	}
	
	
}
