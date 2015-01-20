import java.util.List;
import java.util.Stack;
import java.util.regex.*;




public class CellPrinter {
	
	public static void printUnpaddedCell(Cell c) {
		String value = c.getDisplayableSingleValue();
		if (value.equals(null) || value.equals("")) {
			System.out.println("<empty>");
		} else {
			System.out.println(value);
			System.out.println("\n" + c.getType());
		}
	}

	public static void printPaddedCell(Cell c) throws InvalidInputException {
		String v = "";
		if(c.getType().equals("[Formula]")) {
			String formula = c.getDisplayableSpreadsheetValue();
			v = evaluate(formula);
		} else {
			v = c.getDisplayableSpreadsheetValue();

		}
		if (v.length() > 12) {
			v = v.substring(0, 11) + ">";
		}
		int numOfSpacesRight = (12 - v.length()) / 2;
		int numOfSpacesLeft = 12 - v.length() - numOfSpacesRight;
		leadSpace(numOfSpacesLeft);
		System.out.print(v);
		leadSpace(numOfSpacesRight);
		System.out.print("|");

	}

	private static void leadSpace(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
	}
	
	public static String evaluate(String formula) throws InvalidInputException {
		formula = formula.substring(1, formula.length() - 1);
		Stack<String> st = new Stack<String>();
		List<String> parts = Tokenize.tokenize(formula);
		
	
		for (int i = 0; i < parts.size(); i++) {
			if (parts.get(i).equals("")) {
				continue;
			}
			
			//evaluates all high precedence operators such as, * or /
			if (!st.empty() && (st.peek().equals("*") || st.peek().equals("/"))) {
				String operator = st.pop();
				String operand = st.pop();
				st.push(evaluateString(operand, operator, parts.get(i)));
			} else {
				st.push(parts.get(i));
			}
		}
		
		//Only addition and subtraction operators are left
		while (st.size() > 1) {
			String operandR = (String) st.pop();
			String operator = (String) st.pop();
			String operandL = (String) st.pop();
			st.push(evaluateString(operandL, operator, operandR));
		}
		return st.pop();
	}
	
	public static String evaluateString(String operand1, String operator, String operand2) throws InvalidInputException{
		double left;
		double right;
		try {
			left = Double.parseDouble(operand1);
		} catch (NumberFormatException e) {
			throw new InvalidNumberException(operand1);
		}
		try {
			right = Double.parseDouble(operand2);
		} catch (NumberFormatException e) {
			throw new InvalidNumberException(operand2);
		}
		
		double answer;
		if(operator.equals("+")) {
			answer = left + right;
			return Double.toString(answer);
		} else if(operator.equals("-")) {
			answer = left - right;
			return Double.toString(answer);
		} else if(operator.equals("*")) {
			answer = left * right;
			return Double.toString(answer);
		} else if(operator.equals("/")) {
			if(right == 0) {
				throw new InvalidInputException("Divide by Zero");
			}
			answer = left / right;
			return Double.toString(answer);
		}
		throw new InvalidOperatorException(operator);
	}
	
}

