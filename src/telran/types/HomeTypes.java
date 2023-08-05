package telran.types;

public class HomeTypes {

	public static void main(String[] args) {
		if (args.length==0) {			
			print_values();
			
		} else {
		for (int i=0; i<args.length; i++) {
			min_max_values(args[i]);
			}
		
		}
	}
	private static void min_max_values(String argument) {
		switch (argument) {
		case "byte":
			System.out.println("Byte min: " + Byte.MIN_VALUE); 
			System.out.println("Byte max: " + Byte.MAX_VALUE);
			break;
		case "int":
			System.out.println("Integer min: " + Integer.MIN_VALUE);
			System.out.println("Integer max: " + Integer.MAX_VALUE);
			break;
		case "short":
			System.out.println("Short min: " + Short.MIN_VALUE);
			System.out.println("Short max: " + Short.MAX_VALUE);
			break;			
		case "long":
			System.out.println("Long min: " + Long.MIN_VALUE);
			System.out.println("Long max: " + Long.MAX_VALUE);
			break;
		case "char":
			System.out.println("Char min: " + Character.MIN_VALUE);
			System.out.println("Char max: " + Character.MAX_VALUE);
			break;
		case "float":
			System.out.println("Float min: " + Float.MIN_VALUE);
			System.out.println("Float max: " + Float.MAX_VALUE);
			break;
		case "double":
			System.out.println("Double min: " + Double.MIN_VALUE);
			System.out.println("Double max: " + Double.MAX_VALUE);
			break;		
		default:
			System.out.println(argument+" <argument> Wrong type");
			break;
		}
	}
	
	private static void print_values() {
		System.out.println("Byte min: " + Byte.MIN_VALUE); //byte, int, short, long, char, float, double
		System.out.println("Byte max: " + Byte.MAX_VALUE);
		System.out.println("Integer min: " + Integer.MIN_VALUE);
		System.out.println("Integer max: " + Integer.MAX_VALUE);
		System.out.println("Short min: " + Short.MIN_VALUE);
		System.out.println("Short max: " + Short.MAX_VALUE);
		System.out.println("Long min: " + Long.MIN_VALUE);
		System.out.println("Long max: " + Long.MAX_VALUE);
		System.out.println("Char min: " + Character.MIN_VALUE);
		System.out.println("Char max: " + Character.MAX_VALUE);
		System.out.println("Float min: " + Float.MIN_VALUE);
		System.out.println("Float max: " + Float.MAX_VALUE);
		System.out.println("Double min: " + Double.MIN_VALUE);
		System.out.println("Double max: " + Double.MAX_VALUE);
	}
}
