import static org.junit.Assert.*;

import org.junit.Test;


public class CellMatrixTest {

	@Test
	public void isDoubleTest() {
		assertEquals(true, CellParser.isDouble("1.0"));
		assertEquals(true, CellParser.isDouble("1"));
		assertEquals(true, CellParser.isDouble("-3"));
		assertEquals(true, CellParser.isDouble("-3.0"));
		assertEquals(false, CellParser.isDouble("1/27/2010"));
		assertEquals(false, CellParser.isDouble("hello"));
		assertEquals(false, CellParser.isDouble("\"This ia a string\""));
	}
	
	@Test
	public void isDateTest() {
		assertEquals(true, CellParser.isDate("1/12/2000"));
		assertEquals(true, CellParser.isDate("02/27/2011"));
		assertEquals(false, CellParser.isDate("3.0"));
		assertEquals(false, CellParser.isDate("-5"));
		assertEquals(false, CellParser.isDate("-4.0"));
		assertEquals(false, CellParser.isDate("3"));
		assertEquals(false, CellParser.isDate("hello"));
		assertEquals(false, CellParser.isDate("\"hello\""));		
	}

	@Test
	public void isStringTest() {
		assertEquals(true, CellParser.isString("\"hello\""));
		assertEquals(false, CellParser.isString("hello"));
		assertEquals(false, CellParser.isString("-3"));
		assertEquals(false, CellParser.isString("-3.0"));
		assertEquals(false, CellParser.isString("3.0"));
		assertEquals(false, CellParser.isString("3"));
		assertEquals(false, CellParser.isString("3/20/1990"));
	}
	
	@Test
	public void SpreadsheetTest()  {
		CellMatrix s = CellMatrix.getInstance();
		try {
			s.setValue("A5", "1.3");
			s.setValue("B3", "\"hello\"");
			s.setValue("C6", "9/16/1979");
			s.setValue("G10", "1234");
			s.setValue("Z22", "1234");
		} catch (InvalidCellValueException e) {
		}
		Cell c = s.getCell("A5");
		assertEquals("1.3\n[Number]", c.getDisplayableSingleValue());
		c = s.getCell("B3");
		assertEquals("\"hello\"\n[String]", c.getDisplayableSingleValue());
		c = s.getCell("C6");
		assertEquals("9/16/1979\n[Date]", c.getDisplayableSingleValue());
		c = s.getCell("G10");
		assertEquals("1234\n[Number]", c.getDisplayableSingleValue());
	}
}
