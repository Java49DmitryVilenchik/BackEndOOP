package telran.text.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		assertTrue(Strings.isArithmeticExpression(" 12 "));
		assertTrue(Strings.isArithmeticExpression(" 12/ 300 "));
		assertTrue(Strings.isArithmeticExpression(" 12* 2 /500 + 1000 "));
		assertTrue(Strings.isArithmeticExpression(" 120 / 50 + 100 - 2 * 3 / 500 "));
		
		assertFalse(Strings.isArithmeticExpression(" 12 =18"));
		assertFalse(Strings.isArithmeticExpression(" 12/3&4"));
		assertFalse(Strings.isArithmeticExpression(" 12+ 20 -"));
		assertFalse(Strings.isArithmeticExpression(" 12/ 18 + 100 --10"));
		
	}
}