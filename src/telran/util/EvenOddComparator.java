package telran.util;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		boolean even1=(int)num1 % 2 ==0;
		boolean even2=(int)num2 % 2==0;
		
		if (even1==even2) {
			return (even1) ? num1.compareTo(num2) : num2.compareTo(num1);
		}
		
		return (even1) ? -1 : 1;
		
		//int res=Integer.compare(Math.abs(num1 % 2), Math.abs(num2 % 2));
		// if (res==0) {
		//res=num1%2==0 ? Integer.compare(num1,num2) 
		// : Integer.compare(num2,num1);}
		// return res;
	}

}
