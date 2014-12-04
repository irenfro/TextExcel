
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


public class Test {

	public static int height = 10;
	public static int width = 7;
	public static String[][] data = new String[height+1][width+1];
	
	public static final String EXAMPLE_TEST = "-1";
	
	public static void main(String[] args) throws ParseException, InvalidCellValueException {
		for (int i = 1; i < data[0].length; i++) {
			data[0][i] = (Character.toString((char) (i - 1 + 'A')));
		}

		for (int i = 1; i < data.length; i++) {
			data[i][0] = (Integer.toString(i) + " ");
		}
		String[] array = {"12;hello;\"\";hu;gs;he;th;"};
		loadFrom(array);
		System.out.println(data[1][1]);
}
	public static String[] getSaveData() {
		String[] saveRows = new String[height];
		int posSaveRows = 0;
		for(int i = 1; i < height; i++) {
			String row = "";
			for(int j = 1; j < width; j++) {
				row += data[i][j] + ";";
			}
			saveRows[posSaveRows] = row;
			posSaveRows++;
		}
		return saveRows;
	}
	
	public static void loadFrom(String[] array) throws InvalidCellValueException {
		int posArray = 0;
		for(int i = 1; i < array.length; i++) {
			System.out.println("loading");

			setValue(i, array[posArray]);
			posArray++;
		}
	}
	
	public static void setValue(int row, String rowValue) throws InvalidCellValueException {
		String[] singleValues = rowValue.split(";");
		int posSingleValues = 0;
		for(int i = 1; i < singleValues.length; i++) {
			System.out.println("setting values");
			data[row][i] = singleValues[posSingleValues];
			posSingleValues++;
		}
	}

}
