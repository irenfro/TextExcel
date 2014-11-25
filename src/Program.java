import java.util.Scanner;

public class Program {

	static Spreadsheet s = new Spreadsheet();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
		while (true) {
			System.out.print("\nEnter a command: ");
			String input = sc.nextLine();
			if (input.toLowerCase().equals("exit")) {
				break;
			}
			evaluate(input);
		}
		System.out.println("\nFarewell!");
		sc.close();
	}

	public static void evaluate(String input) {
		String[] Parts = input.split(" ", 3);
		if (Parts.length == 3) {
			if (Parts[1].equals("=")) {
				try {
					s.setValue(Parts[0], Parts[2]);
				} catch (InvalidCellValueException e) {
					System.out.println("Invalid Cell Value. String Cell should be enclosed in \"\".");				
				}
			}

	/*	} else if (parts.size() == 2) {
			if (parts.get(0).equals("clear") && parts.get(1).matches("^[A-Z]+[0-9]+$")) {
				s.clear(parts.get(1));
			}
	*/} else if (Parts.length == 1) {
			if (Parts[0].toLowerCase().equals("print")) {
				System.out.println();
				s.print();
				return;
			} else if (Parts[0].matches("^[A-Z]+[0-9]+$")) {
				s.printValue(Parts[0]);
			}/* else if (parts.get(0).toLowerCase().equals("clear")) {
				s.clear();
			}*/
		}
	}
	
	public static boolean stringCheck(String value) {
		if(value.matches("^-?([0-9]+.?[0-9]*|[0-9]*.[0-9]+)$")) {
			return true;
		}
		if(value.charAt(0) == '"' && value.charAt(value.length() - 1) == '"') {
			return true;
		} else {
			return false;
		}
	}
}
