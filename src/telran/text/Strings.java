package telran.text;

public class Strings {
public static String javaVariableName() {
	
	return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	
}
public static String zero_300() {
	
	return "[1-9]\\d?|[1-2]\\d\\d|300|0";
}
public static String ipV4Octet() {
	//TODO
	//positive 0 255 
	return "(\\d{1,2}|[01]\\d{2}|2[0-4]\\d|25[0-5])";
}
public static String  ipV4() {
	//TODO
	//four ipV4 octets separated by dot 123.123.255.01
	String octetRegex = ipV4Octet();
	String str="\\.";
    //return octetRegex + "\\." + octetRegex + "\\." + octetRegex + "\\." + octetRegex;
    //return String.format("(%s\\.){3}%s", octetRegex, octetRegex); // or this
    return String.format("(%1$s\\.){3}%1$s", octetRegex); // or this
	//return String.format("%1$s%2$s%1$s%2$s%1$s%2$s%1$s", octetRegex, str); // +
    //return String.format("%1$s(%2$s%1$s)*", octetRegex, str);  //!!! not good
	//return String.format(octetRegex + "\\." + octetRegex + "\\." + octetRegex + "\\." + octetRegex);
}
public static String arithmeticExpression() {
	String operandRE=operand();
	String operatorRE=operator();
	return String.format("%1$s(\\s*%2$s\\s*%1$s)*", operandRE, operatorRE);
}
public static String operator() {
	
	return "([-+*/])";
}
public static String operand() {
	
	return "(\\d+)";
}
public static boolean isArithmeticExpression(String expression) {
	expression=expression.trim();
	return expression.matches(arithmeticExpression());
}
}
