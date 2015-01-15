@SuppressWarnings("serial")
	public class InvalidNumberException extends InvalidInputException {
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