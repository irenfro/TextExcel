import java.util.HashSet;
import java.util.List;
import java.util.Stack;


public class FormulaCell extends Cell {
	
	private static CellMatrix matrix = CellMatrix.getInstance();
	private static int count = 0;
	private static int maxChainDepth = 1000;
	private static HashSet hs = new HashSet();
	String value;
	
	public FormulaCell(String newValue) {
		value = newValue;
	}
	
	public void setValue(String newValue) {
		value = newValue;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getType() {
		return "[Formula]";
	}
	
	public String getDisplayableSingleValue() {
		return value;
	}
	
	public String getDisplayableSpreadsheetValue() throws InvalidInputException {
		return evaluate(value);
	}
	
	public static FormulaCell parseCell(String input) {
		try {
			if(input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') {
				return new FormulaCell(input);
			} else {
				return null;
			}
		} catch (NullPointerException e) {
			return null;
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
			
			if(parts.get(i).matches("^[A-Za-z][0-9]")) {
				parts.set(i, getReferencedCellValue(parts.get(i)));
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
	
	private static String getReferencedCellValue(String location) throws InvalidInputException {
		String type = matrix.getCell(location).getType();
		if(hs.contains(location)) {
			hs.clear();
			throw new InvalidInputException("circular reference detected");
		}
		if(matrix.getCell(location).getType().equals("[Formula]")) {
			hs.add(location);
			if(hs.size() >= maxChainDepth) {
				hs.clear();
				throw new InvalidInputException("reference chain is too long");
			}
			String result = evaluate(matrix.getCell(location).getValue());
			hs.remove(location);
			return result;
		} else if(matrix.getCell(location).getType().equals("[Number]")) {
			return matrix.getCell(location).getValue();
		}
		throw new InvalidInputException("not a valid cell type");
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
