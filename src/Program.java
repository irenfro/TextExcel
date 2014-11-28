import java.util.Scanner;

public class Program {

	static Spreadsheet s = new Spreadsheet();

	public static void main(String[] args) throws InvalidCellValueException {
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

	public static void evaluate(String input) throws InvalidCellValueException {
		String[] Parts = input.split(" ", 3);
		if (Parts.length == 3) {
			if (Parts[1].equals("=")) {
				try {
					s.setValue(Parts[0], Parts[2]);
				} catch (InvalidCellValueException e) {
					System.out.println("Invalid Cell Value. String Cell should be enclosed in \"\".");				
				}
			}

		} else if (Parts.length == 2) {
			if (Parts[0].equals("clear") && Parts[1].matches("^[A-Z]+[0-9]+$")) {
				s.clear(Parts[1]);
			}
		} else if (Parts.length == 1) {
			if (Parts[0].toLowerCase().equals("print")) {
				System.out.println();
				s.print();
				return;
			} else if (Parts[0].matches("^[A-Z]+[0-9]+$")) {
				s.printValue(Parts[0]);
			}else if (Parts[0].toLowerCase().equals("clear")) {
				s.clear();
			}
	 	} else {
	 		System.out.println(input + ": is not a vaild command");
	 	}
	}
}
