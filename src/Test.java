import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Test {
	
	public static void main(String[] args) throws InvalidInputException {
		List<String> parts = Tokenize.tokenize("(sum A5 - G10)");
		sum(parts);
	}
	
	public static double sum(List<String> equation) throws InvalidCellException {
		String startCell = "";
		String endCell = "";
		for(int i = 0; i < equation.size() - 1; i++) {
			if(equation.get(i).matches("^[A-Za-z][0-9]+")) {
				if(startCell.equals("")) {
					startCell = equation.get(i);
				} else if(endCell.equals("")) {
					endCell = equation.get(i);
				} else {
					throw new InvalidCellException ("too many cell references for sum");
				}
			}
		}
		System.out.println(startCell);
		System.out.println(endCell);
		
		char startLetter = startCell.charAt(0);
		char endLetter = endCell.charAt(0);
		
		int startCol = (int) (startLetter - 'A' + 1);
		int endCol = (int) (endLetter - 'A' + 1);
		System.out.println(startCol);
		System.out.println(endCol);
		
		int startRow = Integer.parseInt(startCell.substring(1));
		int endRow = Integer.parseInt(endCell.substring(1));
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		double answer = 0;
		int count = 1;
		for(int i = startRow; i <= endRow; i++) {
			System.out.println();
			for(int j = startCol; j <= endCol; j++) {
				char c = (char) ('A' + (j-1));
				//answer = Double.parseDouble(getReferencedCell(""+c+i));
			}
			count--;
		}
		return answer;
	}
	
	
}
