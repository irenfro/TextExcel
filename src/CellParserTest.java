import static org.junit.Assert.*;

import org.junit.Test;


public class CellParserTest {

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
}
