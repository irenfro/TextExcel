import java.util.Scanner;

public class TextExcel {

	static CellMatrix s = CellMatrix.getInstance();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
		System.out.print("\nEnter a command: ");
		String input = sc.nextLine();
		while (!input.toLowerCase().equals("exit")) {
			evaluate(input);
			System.out.print("\nEnter a command: ");
			input = sc.nextLine();
		}
		System.out.println("\nFarewell!");
		sc.close();
	}

	public static void evaluate(String input) throws Exception {
		String[] parts = input.split(" ", 3);
		
		if (parts.length == 3) {
			if (parts[1].equals("=")) {
				try {
					s.setValue(parts[0], parts[2]);
				} catch (InvalidCellValueException e) {
					System.out.println("Invalid Cell Value. "
							+ "\nA String should be enclosed in \"\"."
							+ "\nA Date should be a valid date within the 12 months and a date between 1 and 31."
							+ "\nA Double or Number should just be any number");				
				}
			} else if(parts[0].toLowerCase().equals("help")){
				help(parts[1]+" "+parts[2]);
			}

		} else if (parts.length == 2) {
			if (parts[0].toLowerCase().equals("clear") && parts[1].matches("^[A-Z]+[0-9]+$")) {
				s.clear(parts[1]);
			} else if (parts[0].toLowerCase().equals("save")) {
				PersistenceHelper.save(parts[1], s);
			} else if (parts[0].toLowerCase().equals("load")) {
				PersistenceHelper.load(parts[1], s);			
			} else if(parts[0].toLowerCase().equals("help")){
				help(parts[1]);
			}
		} else if (parts.length == 1) {
			if (parts[0].toLowerCase().equals("print")) {
				System.out.println();
				s.print();
				return;
			} else if (parts[0].matches("^[A-Z]+[0-9]+$")) {
				s.printValue(parts[0]);
			}else if (parts[0].toLowerCase().equals("clear")) {
				s.clear();
			} else if(parts[0].toLowerCase().equals("help")) {
				System.out.println("print: prints the spreadsheet\n"
						+ "exit: quits the program\n"
						+ "clear: clears the spreadsheet\n"
						+ "clear Cell : clears a given cell\n"
						+ "save name: saves the spreadsheet with the given name\n"
						+ "load name: loads the spreadsheet from the file with given name\n"
						+ "help <function> : extra help on a function");
			}
	 	} else {
	 		System.out.println(input + ": is not a vaild command");
	 	}
	}

	private static void help(String input) {
		char first = input.charAt(0);
		char last = input.charAt(input.length() - 1);
		if(Character.toString(first).equals("<") && Character.toString(last).equals(">")) {
			input = input.substring(1, input.length() - 1);
		}
		input = input.toLowerCase();
		System.out.println();
		switch(input) {
		case "print": 
			System.out.println("The print function prints out the spreadsheet "
					+ "with the current vaules of each cell");
			break;
		case "exit":
			System.out.println("The exit function quits the program");
			break;
		case "clear":
			System.out.println("The clear function clears the entire spreadsheet");
			break;
		case "clear Cell":
			System.out.println("The clear Cell function clears the specific cell");
			break;
		case "save name":
			System.out.println("The save name function saves the spreadsheet with the given name"
					+ " in the same folder as the java files");
			break;
		case "load name":
			System.out.println("The load name function loads the spreadsheet file with the given name"
					+ " from the same folder as the java files");
		default:
			System.out.println(input + ": is not a valid command");
		}
			
	}
}
