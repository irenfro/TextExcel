import java.util.Scanner;


public class Program {
	
	static Spreadsheet s = new Spreadsheet();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
		while(true) {
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
		String[] parts = input.split(" ");
		if(parts.length == 3 ){
				if(parts[1].equals("=")) {
					if(parts[2].matches("^-?([0-9]+.?[0-9]*|[0-9]*.[0-9]+)$")) {
						s.setValue(parts[0], Double.parseDouble(parts[2]));
						return;
					}	else if(parts[2].matches("^-?[0-9]")){
						s.setValue(parts[0], Integer.parseInt(parts[2]));
						return;
					}	else {
						s.setValue(parts[0], parts[2]);
						return;
					}
				}
				
		} else if(parts.length == 2) {
			if(parts[0].equals("clear") && parts[1].matches("^[A-Z]+[0-9]+$")) {
				s.clear(parts[1]);
			}
		} else if(parts.length == 1) {
				if(parts[0].toLowerCase().equals("print")) {
					System.out.println();
					s.print();
					return;
				} else if(parts[0].matches("^[A-Z]+[0-9]+$")) {
					s.printValue(parts[0]);
				} else if(parts[0].toLowerCase().equals("clear")) {
					s.clear();
				}
		}
	}
}

