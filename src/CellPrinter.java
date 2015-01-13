import java.util.Stack;



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
		Stack<String> st = new Stack<String>();
		String[] parts = formula.split(" ");

		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals("")) {
				continue;
			}
			
			//evaluates all high precedence operators such as, * or /
			if (!st.empty() && (st.peek().equals("*") || st.peek().equals("/"))) {
				String operator = st.pop();
				String operand = st.pop();
				st.push(evaluateString(operand, operator, parts[i]));
			} else {
				st.push(parts[i]);
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
		double left = Double.parseDouble(operand1);
		double right = Double.parseDouble(operand2);
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
	
	
	@SuppressWarnings("serial")
	public static class InvalidInputException extends Exception {
		// New Exception To handle Invalid Inputs and gives the user
		// a helpful error message
		public InvalidInputException(String message) {
			super(message);
		}
	}
	
	@SuppressWarnings("serial")
	public static class InvalidOperatorException extends InvalidInputException {
		// New Exception to handle InvalidOperators and gives the user
		// a helpful error message
		public InvalidOperatorException(String operator) {
			super(operator + " is not a valid operator."
					+ "\nValid operators: + or - or * or /");
		}
	}
	@SuppressWarnings("serial")
	public static class InvalidNumberException extends InvalidInputException {
		// New Exception to handle InvalidNumbers and gives the user
		// a helpful error message
		public InvalidNumberException(String number) {
			super(
					number
							+ " is not a valid number. "
							+ "\nCorrect format: number (space) operator (space) number ..."
							+ "\nValid format of numbers: 1 or 1.0");
		}
	}	
}

