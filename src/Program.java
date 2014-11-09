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
		if(parts.length == 3 && parts[1].equals("=")) {
			s.setValue(parts[0], parts[2]);
			return;
		}
		if(parts.length == 1 && parts[0].toLowerCase().equals("print")) {
			System.out.println();
			s.print();
			return;
		}
	}
}

