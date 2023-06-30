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
    return octetRegex + "\\." + octetRegex + "\\." + octetRegex + "\\." + octetRegex;

}
}
