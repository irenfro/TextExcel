
public class Program {
	
	public static void main(String[] args) {
		Spreadsheet s = new Spreadsheet();
		s.setValue("A1", 1);
		s.setValue("C4", "Hi");
		s.print();
	}
}
