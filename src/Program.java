//import java.util.Scanner;


public class Program {
	
	public static void main(String[] args) {
		Spreadsheet s = new Spreadsheet();
		s.setValue("A1", 1);
		s.setValue("C4", "Hi");
		s.setValue("B5", "Helloasdhfodfg");
		s.print();
	}
}

/*
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome to TextExcel!");
	while(true) {
		System.out.print("\nEnter a command: ");
		String input = sc.nextLine();
		
		if (input.toLowerCase().equals("exit")) {
			break;
		}
		
		if (input.equals("print")) {
			print();
		}
		
	}
	System.out.println("\nFarewell!");
*/