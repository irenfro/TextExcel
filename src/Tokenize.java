import java.util.ArrayList;
import java.util.List;


public class Tokenize {
	public static List<String> tokenize(String input) throws InvalidInputException {
		List<String> tokens = new ArrayList<String>();
		String s = "";
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String part = Character.toString(c);
			if(part.matches("[A-Za-z]")) {
				s += Character.toString(c);
				continue;
			} else if(part.equals("+") || part.equals("-") || 
					  part.equals("*") || part.equals("/")) {
				if(i > 0 && (tokens.get(tokens.size()-1).equals("+") ||
						tokens.get(tokens.size()-1).equals("-") ||
						tokens.get(tokens.size()-1).equals("*") ||
						tokens.get(tokens.size()-1).equals("/")) 
				         && part.equals("-")) {
					s += part;
					continue;
				}
				if(s.length() > 0) {
					tokens.add(s);
				}
				s = Character.toString(c);
				tokens.add(s);
				s = "";
				continue;
			} else if(part.equals("0") || part.equals("1") || part.equals("2") || 
					  part.equals("3") || part.equals("4") || part.equals("5") || 
					  part.equals("6") || part.equals("7") || part.equals("8") || part.equals("9")) {
				s += Character.toString(c);
				continue;
			} else if(part.equals(" ") || part.equals("(") || part.equals(")")){
				if(s.length() > 0) {
					tokens.add(s);
					s = "";
				}
				continue;
			} else {
				tokens.add(Character.toString(c));
			}
		}
		if(s.length() > 0) {
			tokens.add(s);
			s = "";
		}
		
		return tokens;
	}
}
