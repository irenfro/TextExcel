@SuppressWarnings("serial")
	public class InvalidCellException extends InvalidInputException {
		// New Exception to handle InvalidNumbers and gives the user
		// a helpful error message
		public InvalidCellException(String cellLocation) {
			super(
					cellLocation
							+ " is not a valid cell location.\n"
							+ "Valid cell locations are rows 1-10 and columns A-G . ");
		}
	}	