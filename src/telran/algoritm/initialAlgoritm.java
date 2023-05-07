package telran.algoritm;

import java.util.Arrays;
import java.util.Comparator;

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
		int helperSize=sum < 0 ? Short.MAX_VALUE+1 : sum+1;
		boolean[] helper=new boolean[helperSize];
		boolean res=false;
		int index=0;
		while (index<array.length && !res) {
			short value=array[index];
			short secondValue=(short)(sum-value);
			if (secondValue>=0) {
				if (helper[secondValue]) {
					res=true;
				}
				else {
					helper[value]=true;
				}
		}
			index++;
			
	}
		return res;
	}	
	
		//public static boolean isSumTwo(short[] array, short sum) {
		//	boolean[] seen = new boolean[Short.MAX_VALUE+1];
	    //    for (short num : array) {
	    //        if (sum - num >= 0 && seen[sum - num]) {
	    //            return true;
	    //        } else {
	    //            seen[num] = true;
	    //        }
	    //    }
	    //    return false;
		//}
		
			//return maximal positive number for which there is negative image
			//if there not such numbers at all the method return -1
			
		
		
	//	public static short getMaxPositiveWithNegativeReflect(short[] array) {
	//	    short maxPositive = -1;
	//	    boolean[] seen = new boolean[Short.MAX_VALUE+1];

	//	    for (short num : array) {
	//	        if (num >= 0) {
	//	            short negativeImage = (short) (-1 * num);
	//	            if (negativeImage <= Short.MAX_VALUE && seen[(short)negativeImage]) { //
	//	                maxPositive = num > maxPositive ? num : maxPositive;
	//	            }
	//	        } else {
	//	            seen[(short)-1 * num] = true;
	//	        }
	//	    }

	//	    return maxPositive;
	//	}


	public static short getMaxPositiveWithNegativeReflect(short[] array) {
		short res=-1;
		byte helper[]=new byte[Short.MIN_VALUE];
		short candidade=-1;
		for (int i=0; i<array.length; i++) {
			candidade=(short) Math.abs(array[i]);
			if (array[i]<0) {
				if (helper[candidade]==1 && candidade>res) {
					res=candidade;
				} else if (helper[candidade]==0) {
					helper[candidade]=-1;
				}
			}
		}
		
		return res;
		
	}
	
	public static <T> int binarySearch(T [] array, T key, Comparator<T> comp) {
		int leftIndex=0;
		int rightIndex=array.length-1;
		int middleIndex=(rightIndex-leftIndex)/2;
		int compRes=0;
		while (leftIndex<=rightIndex && (compRes=comp.compare(key, array[middleIndex]))!=0) {
			if (compRes>0) {
				//move to right
				leftIndex=middleIndex+1;
			} else {
				rightIndex=middleIndex-1;
			}
			middleIndex=(leftIndex+rightIndex)/2;
		}
		return leftIndex>rightIndex ? -1 : middleIndex;
		
	}
}
