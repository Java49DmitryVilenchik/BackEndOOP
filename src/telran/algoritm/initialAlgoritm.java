package telran.algoritm;

public class initialAlgoritm {
	public static void sortShortPositive(short [] array) {
		//array of the positive short numbers
		int [] helper= new int[Short.MAX_VALUE];
		//helper[index] => count of occurenses for number index in array
		//helper[1000]=2 => number 1000 occurs twice in source array
		//helper[2]=0;
		for (int i=0; i<array.length; i++) {
			helper[array[i]]++;
		}
		int ind=0;
		for (int i=0;i<helper.length;i++) {
			for (int j=0; j<helper[i]; j++) {
			array[ind++]=(short) i;	
			}
		}
	}
		public static boolean isSumTwo(short[] array, short sum) {
			//returns true if there are two numbers in the given array,
			//sum of which equals the given sum value
			//othervise false
			return false;
		}
		public static short getMaxPositiveWithNegativeReflect(short[] array) {
			//return maximal positive number for whict there is negative image
			//if there not such numbers at all the method return
			return -1;
		
	}
	
}
