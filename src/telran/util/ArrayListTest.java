package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList<Integer> numbers= new ArrayList<>();
		ArrayList<String> strings= new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("ABC");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
	}
	@Test
	void testAddIndex() {
		ArrayList<Integer> numbers= new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(4);
		numbers.add(5);
		
		numbers.add(0, 10);
		numbers.add(2, 3);
		numbers.add(6, 6);		
		
		assertEquals(7, numbers.size());
		
		assertEquals(10, numbers.get(0));
		assertEquals(3, numbers.get(2));
		assertEquals(6, numbers.get(6));		
			
	}
	@Test
	void testRemoveIndex() {
		ArrayList<Integer> numbers= new ArrayList<>();
		numbers.add(1); //-
		numbers.add(2);
		numbers.add(3); //-
		numbers.add(4);
		numbers.add(5); //-
		numbers.add(6);
		
		numbers.remove(0);
		numbers.remove(1);
		numbers.remove(2);
		
		assertEquals(2, numbers.get(0));
		assertEquals(4, numbers.get(1));
		assertEquals(6, numbers.get(2));
		
		assertEquals(3, numbers.size());
	}
}
