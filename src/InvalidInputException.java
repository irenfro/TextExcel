@SuppressWarnings("serial")
	public class InvalidInputException extends Exception {
		// New Exception To handle Invalid Inputs and gives the user
		// a helpful error message
		public InvalidInputException(String message) {
			super(message);
		}
	}