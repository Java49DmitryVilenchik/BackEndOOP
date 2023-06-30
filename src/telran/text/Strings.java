package telran.text;

import java.util.HashMap;
import java.util.NoSuchElementException;
//import java.util.Objects;

//import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class Strings {
	static HashMap<String, DoubleBinaryOperator> mapOperations;
	static {
		mapOperations=new HashMap<>();
		mapOperations.put("-", (a, b) -> a-b );
		mapOperations.put("+", (a, b) -> a+b );
		mapOperations.put("*", (a, b) -> a*b );
		mapOperations.put("/", (a, b) -> a/b );
	}
public static String javaVariableName() {
	
	return "([a-zA-Z$][\\w$]*|_[\\w$]+)";
	
}
public static String zero_300() {
	
	return "[1-9]\\d?|[1-2]\\d\\d|300|0";
}
public static String ipV4Octet() {
	
	//positive 0 255 
	return "(\\d{1,2}|[01]\\d{2}|2[0-4]\\d|25[0-5])";
}
public static String  ipV4() {
	
	//four ipV4 octets separated by dot 123.123.255.01
	String octetRegex = ipV4Octet();
	//String str="\\.";
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
//	return String.format("%1$s(\\s*%2$s\\s*%1$s)*", operandRE, operatorRE); //убрали пробелы
	return String.format("%1$s(%2$s%1$s)*", operandRE, operatorRE);
}
public static String operator() {
	// return "([-+*/])";
	return "\\s*([-+*/])\\s*";   //insert space
}
public static String operand() {
	
	return "(\\d+)";
}
public static boolean isArithmeticExpression(String expression) {
	expression=expression.trim();
	return expression.matches(arithmeticExpression());
}
public static Double computeExpression(String expression) {
	
	if (!isArithmeticExpression(expression)) {
		throw new IllegalArgumentException("Wrong arithmetic expression");
	}
	expression = expression.replaceAll("\\s+", "");
	String[] operands = expression.split(operator());
	String [] operators = expression.split(operand());
	Double res = (double) Integer.parseInt(operands[0]);
	for(int i = 1; i < operands.length; i++) {
		int operand = Integer.parseInt(operands[i]);
		res = mapOperations.get(operators[i]).applyAsDouble(res, operand);
	}
	
	return res;
}
//Update whole code for any numbers (double)
//Update code taking into consideration possible variable names
public static double computeExpression(String expression, HashMap<String, Double> mapVariables) {
    if (!isArithmeticExpression(expression)) {
        throw new IllegalArgumentException("Wrong arithmetic expression");
    }
    expression = expression.replaceAll("\\s+", "");
    String[] operands = expression.split(operator());
    String[] operators = expression.split(operand());
    double res = Double.parseDouble(operands[0]);
    for (int i = 1; i < operands.length; i++) {
        String operator = operators[i];
        double value = getValue(operands[i], mapVariables);
        res = mapOperations.get(operator).applyAsDouble(res, value);
    }
    return res;
}

private static double getValue(String operand, HashMap<String, Double> mapVariables) {
    try {
        return Double.parseDouble(operand);
    } catch (NumberFormatException e) {
        if (mapVariables.containsKey(operand)) {
            return mapVariables.get(operand);
        } else {
            throw new NoSuchElementException("Missing value of variable: " + operand);
        }
    }
}
}
