package telran.text.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
//import junit.framework.Assert;

import telran.text.Strings;

class StringsTest {

	@Test
	void test() {
		//String regex="gray|grey|griy";
//		String regex="gr(a|e|i)y";
//		assertTrue("gray".matches(regex));
//		assertTrue("grey".matches(regex));
//		assertTrue("griy".matches(regex));
//		assertFalse("groy".matches(regex));
//		String regex="a?1234";
//		assertTrue("a1234".matches(regex));
//		assertTrue("1234".matches(regex));
//		assertFalse("d1234".matches(regex));
//		assertFalse("aa1234".matches(regex));
//		String regex="a*1234";
//		assertTrue("a1234".matches(regex));
//		assertTrue("1234".matches(regex));
//		assertFalse("d1234".matches(regex));
//		assertTrue("aa1234".matches(regex));
//		String regex="a+1234";
//		assertTrue("a1234".matches(regex));
//		assertFalse("1234".matches(regex));
//		assertFalse("d1234".matches(regex));
//		assertTrue("aa1234".matches(regex));
//		String regex="(a|b)+1234";
//		assertTrue("a1234".matches(regex));
//		assertFalse("1234".matches(regex));
//		assertTrue("b1234".matches(regex));
//		assertTrue("aa1234".matches(regex));
		
	}
	@Test
	void javaVariableNameTest() {
		String regex=Strings.javaVariableName();
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex));
		assertTrue("$2".matches(regex));
		assertTrue("$_".matches(regex));
		assertTrue("__".matches(regex));
		assertTrue("_2".matches(regex));
		assertTrue("a_b".matches(regex));
		assertTrue("A_B".matches(regex));
		assertTrue("abc12345678900000".matches(regex));
		assertFalse("1a".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a#".matches(regex));
		assertFalse("a b".matches(regex));
		assertFalse("a-b".matches(regex));
		assertFalse("A-B".matches(regex));
		assertFalse(" ab".matches(regex));
//		int 1a;
//		int $;
//		int $2;
//		int $_;
//		int __;
//		int _2;
//		int _;
//		int a#;
//		int a b;
//		int a_b;
//		int a-b;
//		int abc1234567890;
	}
	@Test
	void zero_300Test() {
		String regex=Strings.zero_300();
		assertTrue("0".matches(regex));
		assertTrue("9".matches(regex));
		assertTrue("299".matches(regex));
		assertTrue("300".matches(regex));
		assertTrue("99".matches(regex));
		assertFalse("01".matches(regex));
		assertFalse("00".matches(regex));
		assertFalse("1111".matches(regex));
		assertFalse("301".matches(regex));
		assertFalse("3000".matches(regex));
		assertFalse("310".matches(regex));
		assertFalse("-1".matches(regex));
		assertFalse(" 3".matches(regex));
	}
	@Test
	void ipv4OctetTest() {
		String regex=Strings.ipV4Octet();
		assertTrue("000".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("0".matches(regex));
		assertTrue("99".matches(regex));
		assertTrue("1".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("200".matches(regex));
		assertTrue("255".matches(regex));
		assertFalse("0000".matches(regex));
		assertFalse(" 1".matches(regex));
		assertFalse(".0".matches(regex));
		assertFalse("-1".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("1000".matches(regex));
	}
	@Test
	void IpV4Test() {
		String regex=Strings.ipV4();
		assertTrue("0.0.0.0".matches(regex));
		assertTrue("5.5.5.5".matches(regex));
		assertTrue("100.199.200.255".matches(regex));
		assertFalse(".1.2.3.4".matches(regex));
		assertFalse("1.2.3.4.".matches(regex));
		assertFalse(".1.&2.3.4".matches(regex));
		assertFalse("1.2.3".matches(regex));
		assertFalse(".1.2.3.4.5".matches(regex));
		assertFalse("123 123 123 123".matches(regex));
	}
	@Test
	void arithmeticExpressionTest() {
		assertTrue(Strings.isArithmeticExpression(" 12 "));//12
		assertTrue(Strings.isArithmeticExpression(" 12/ 6 "));//2
		assertTrue(Strings.isArithmeticExpression("12/2"));//6
		assertTrue(Strings.isArithmeticExpression(" 12* 2 /3 + 1000 ")); //1008
		assertTrue(Strings.isArithmeticExpression(" 120 / 50 + 100 - 2 * 3 / 500 "));//0
		
		assertFalse(Strings.isArithmeticExpression(" 12 18"));
		assertFalse(Strings.isArithmeticExpression(" 12/3&4"));
		assertFalse(Strings.isArithmeticExpression(" 12+ 20 -"));
		assertFalse(Strings.isArithmeticExpression(" 12/ 18 + 100 10"));
		
	}
	@Test
	void computeExpressionTest() {
	    assertEquals(12.0, Strings.computeExpression(" 12 ", new HashMap<>()));
	    assertEquals(2.0, Strings.computeExpression(" 12/ 6 ", new HashMap<>()));
	    assertEquals(6.0, Strings.computeExpression("12/2", new HashMap<>()));
	    assertEquals(1008.0, Strings.computeExpression(" 12*  2 / 3 + 1000 ", new HashMap<>()));
	    assertEquals(0.6024, Strings.computeExpression(" 120 / 50 + 100 - 2 * 3 / 500 ", new HashMap<>()));

	    HashMap<String, Double> mapVariables = new HashMap<>();
        mapVariables.put("x", 5.0);
        mapVariables.put("y", 2.0);
        mapVariables.put("z", 3.0);
//        assertEquals(2.5, Strings.computeExpression(" x / y ", mapVariables));
//        assertEquals(0.0, Strings.computeExpression(" x - y - z ", mapVariables));
	    
	}
	@Test
    void javaVariableNameTest1() {
        String regex = Strings.javaVariableName();
        assertTrue("a".matches(regex));
        assertTrue("$".matches(regex));
        assertTrue("$2".matches(regex));
        assertTrue("$_".matches(regex));
        assertTrue("__".matches(regex));
        assertTrue("_2".matches(regex));
        assertTrue("a_b".matches(regex));
        assertTrue("A_B".matches(regex));
        assertTrue("abc12345678900000".matches(regex));
        assertFalse("1a".matches(regex));
        assertFalse("_".matches(regex));
        assertFalse("a#".matches(regex));
        assertFalse("a b".matches(regex));
        assertFalse("a-b".matches(regex));
        assertFalse("A-B".matches(regex));
        assertFalse(" ab".matches(regex));
    }
}
