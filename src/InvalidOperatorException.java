@SuppressWarnings("serial")
	public class InvalidOperatorException extends InvalidInputException {
		// New Exception to handle InvalidOperators and gives the user
		// a helpful error message
		public InvalidOperatorException(String operator) {
			super(operator + " is not a valid operator."
					+ "\nValid operators: + or - or * or /");
		}
	}