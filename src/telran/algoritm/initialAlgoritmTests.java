package telran.algoritm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.algoritm.*;

class initialAlgoritmTests {
	@Test
	void isSumTwoTest() {
		short[] arr = {2, 3, 5, 8, 10};
        short sum = 13;
        short sum2=9;
        assertTrue(initialAlgoritm.isSumTwo(arr, sum));
        assertFalse(initialAlgoritm.isSumTwo(arr, sum2));
        
        short[] array= {30000, 1, 5, 2, 10000, 0, 500, 0};
        short[] array1= {30000, 1, 5, 2, 10000, 0, 500, 0, Short.MAX_VALUE};
        assertTrue(initialAlgoritm.isSumTwo(array, (short)30000));
        assertTrue(initialAlgoritm.isSumTwo(array, (short) (7)));
        assertFalse(initialAlgoritm.isSumTwo(array, (short) (30003)));
        assertFalse(initialAlgoritm.isSumTwo(array, (short) (8)));
        assertTrue(initialAlgoritm.isSumTwo(array1, Short.MIN_VALUE));
	}
	@Test
	@Disabled
	void isGetMaxPositiveWithNegativeReflectTest() {
		short[] array = {1, 2, 3, -3, -2, 4};
	    short expected = 3;
	    short actual = initialAlgoritm.getMaxPositiveWithNegativeReflect(array);
	    assertEquals(expected, actual);
	//    System.out.println(initialAlgoritm.getMaxPositiveWithNegativeReflect(array));
		
		short[] arr1 = {1, 2, -3, 4, -2};
	//    System.out.println(initialAlgoritm.getMaxPositiveWithNegativeReflect(arr1)); // Expected output: 2

	    short[] arr2 = {1, 2, 3, 4};
	    System.out.println(initialAlgoritm.getMaxPositiveWithNegativeReflect(arr2)); // Expected output: -1

	    short[] arr3 = {1, 2, 3, -1, -2, -3, 4, 5, -4};
//	    System.out.println(initialAlgoritm.getMaxPositiveWithNegativeReflect(arr3)); // Expected output: 3

	    short[] arr4 = {-1, -2, -3, -4};
//	    System.out.println(initialAlgoritm.getMaxPositiveWithNegativeReflect(arr4)); // Expected output: -1
	}

}
