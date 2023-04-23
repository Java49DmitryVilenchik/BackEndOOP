package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.*;

class ArrayListTest {
List<Integer> list;
Integer[] numbers= {10, -20, 7, 50, 100, 30};
	@BeforeEach
void setUp() {
	list=new ArrayList<>(1);
	for (int i=0; i<numbers.length; i++) {
		list.add(numbers[i]);
	}
}
	@Test
	void testAdd() {
		//ArrayList<Integer> numbers= new ArrayList<>();
		//ArrayList<String> strings= new ArrayList<>();
		//numbers.add(5);
		//numbers.add(10);
		//strings.add("ABC");
		//assertEquals(2, numbers.size());
		//assertEquals(1, strings.size());
		
		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length+1, list.size());
	}
	@Test
	void testAddIndex() {
		//ArrayList<Integer> numbers= new ArrayList<>();
		//numbers.add(1);
		//numbers.add(2);
		//numbers.add(4);
		//numbers.add(5);		
		//numbers.add(0, 10);
		//numbers.add(2, 3);
		//numbers.add(6, 6);		
		//assertEquals(7, numbers.size());		
		//assertEquals(10, numbers.get(0));
		//assertEquals(3, numbers.get(2));
		//assertEquals(6, numbers.get(6));		
		
		Integer[] expected0_500= {500, 10, -20, 7, 50, 100, 30};
		Integer[] expected0_500_3_700= {500, 10, -20, 700, 7, 50, 100, 30};
		Integer [] expected0_500_3_700_8_300={500, 10, -20, 700, 7, 50, 100, 30, 300};
		list.add(0,500);
		runTest(expected0_500);
		list.add(3,700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
		
		
	}
	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}
	private void runTest(Integer[] expected) {
		int size=list.size();
		Integer [] actual=new Integer[expected.length];
		
		for (int i=0; i<size;i++) {
			actual[i]=list.get(i);
			
		}
		assertArrayEquals(expected, actual);
	}
	@Test
	void testIndexOf() {
		list.add(3, 10);
		assertEquals(0, list.indexOf(10));
		assertEquals(-1, list.indexOf((Integer)null));
	}
	@Test
	void testLastIndexOf() {
		list.add(3, 10);		
		assertEquals(3, list.lastIndexOf(10));		
		assertEquals(-1, list.lastIndexOf((Integer)null));
	}
	@Test
	void testRemove() {
		//numbers= {10, -20, 7, 50, 100, 30};
		assertTrue(list.remove(numbers[5]));
		assertEquals(100, list.get(4));
		
		assertTrue(list.remove(numbers[0]));
		assertEquals(-20, list.get(0));
		
		assertFalse(list.remove(numbers[5]));
	}
	@Test
	void testRemoveIndex() {
		//ArrayList<Integer> numbers= new ArrayList<>();
		//numbers.add(1); //-
		//numbers.add(2);
		//numbers.add(3); //-
		//numbers.add(4);
		//numbers.add(5); //-
		//numbers.add(6);
		
		//numbers.remove(0);
		//numbers.remove(1);3;
		//numbers.remove(2);
		
		//assertEquals(2, numbers.get(0));
		//assertEquals(4, numbers.get(1));
		//assertEquals(6, numbers.get(2));
		
		//assertEquals(3, numbers.size());
		Integer [] expectedNo10= { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50= {-20, 7, 100, 30};
		Integer [] expectedNo10_50_30= {-20, 7, 100};
		
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
		
		}
	@Test
	void toArray() {
		assertEquals(numbers, list.toArray(numbers));
				
		ArrayList<String> str= new ArrayList<>();
		
		str.add("abc");
		str.add("I");
		str.add("love");
		str.add("world");
		String[] arr=new String[4];
		arr[0]="abc";
		arr[1]="I";
		arr[2]="love";
		arr[3]="world";
		
		String[] arrayOfStrings = {"abc","I","love","world","yo", "many"};
		String[] arrayOfStrings1 = {"abc","I","love","world"};
		String[] arrayOfStrings2 = {"abc","I",null,null};
		String[] arrayOfStrings3 = {"abc","I","love","world",null,"many"};
		
        
        //arrayOfStrings =(String[]) str.toArray(new String[str.size()]);
        //Arrays.toString(arrayOfStrings);
       //String[] arr1=Arrays.toString(arrayOfStrings);
		
		assertEquals(arr, str.toArray(arr));
		//assertEquals(arrayOfStrings3, str.toArray(arrayOfStrings));
		assertEquals(arrayOfStrings1, str.toArray(arrayOfStrings1));
		
		Integer[] ActualArray=list.toArray(new Integer[0]);
		assertArrayEquals(numbers, ActualArray);
	}
	@Test
	void testSort() {
		Integer expexted[]= {-20, 7, 10, 30, 50, 100};
		list.sort();
		assertArrayEquals(expexted, list.toArray(new Integer[0]));
	}
	@Test
	void testSortPersons() {
		List<Person> persons=new ArrayList<>();
		Person p1=new Person(123, 25, "Vasja");
		Person p2=new Person(124, 20, "Asaf");
		Person p3=new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[]= {p3, p1, p2};
		persons.sort();
		assertArrayEquals(expected, persons.toArray(new Person[0]));
	}
	@Test
	void testSortPersonsByAge() {
		List<Person> persons=new ArrayList<>();
		Person p1=new Person(123, 25, "Vasja");
		Person p2=new Person(124, 20, "Asaf");
		Person p3=new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[]= {p2,p1,p3};
		
		//persons.sort(new PersonAgeComparator());
		persons.sort((pers1,pers2)-> Integer.compare(pers1.getAge(), pers2.getAge()));
		assertArrayEquals(expected, persons.toArray(new Person[0]));		
	}
	@Test
	void testSortComp () {
		Integer expexted[]= {-20, 7, 10, 30, 50, 100};
		list.sort(new IntegerComparator());		
		assertArrayEquals(expexted, list.toArray(new Integer[0]));
	}
	@Test
	void testSortPersonsByName() {
		List<Person> persons=new ArrayList<>();
		Person p1=new Person(123, 25, "Vasja");
		Person p2=new Person(124, 20, "Asaf");
		Person p3=new Person(120, 50, "Boris");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[]= {p2,p3,p1};
		
		persons.sort(new PersonNameComparator());
		assertArrayEquals(expected, persons.toArray(new Person[0]));
	}
	@Test
	void testEvenOdd() {
		//Integer start[]={10, -20, 7, 50, 100, 30, =17=};
		list.add(17);
		Integer expected[]={-20,10,30,50,100,17,7};
		
		//list.sort(new EvenOddComparator());
		
		list.sort((num1 , num2) -> {
		int res=Integer.compare(Math.abs(num1 % 2), Math.abs(num2 % 2));
		 if (res==0) {
		res=num1%2==0 ? Integer.compare(num1,num2) 
		 : Integer.compare(num2,num1);}
		 return res;
		});
		assertArrayEquals(expected, list.toArray(new Integer[0]));
	}
	@Test
	void testIndexOfPredicate() {
		assertEquals(1, list.indexOf(a -> a<0));
		assertEquals(-1, list.indexOf(a -> a%2 <0));
		assertEquals(-1, list.indexOf(a -> a%2 >0 && a>10));
	}
	@Test
	void testLastIndexOfPredicate() {
		list.add(17);
		list.add(17);
		assertEquals(7, list.lastIndexOf(a-> a==17));
	}
	@Test
	void testRemoveIfAll( ) {
		//Integer start[]={10, -20, 7, 50, 100, 30};
		
		list.add(100);
		list.add(100);
		list.add(100);
		list.add(0,100);
		list.add(1,100);
		list.add(2,100);
				
		Integer expected[]={10, -20, 7, 50, 30};
		assertEquals(12, list.size());
		assertTrue(list.removeIf(a -> a==100));
		assertArrayEquals(expected, list.toArray(new Integer[0]));
		
		
		assertTrue(list.removeIf(a -> true));		
		assertEquals(0, list.size());
		
		//assertTrue(list.removeIf(a -> a>40));
		//Integer expected[]={10, -20, 7, 30};
		//assertArrayEquals(expected, list.toArray(new Integer[0]));
		//assertEquals(3, list.size());
		
		//list.add(100);
		//list.add(2,100);
		//list.add(0,100);
		//Integer expected[]={10, -20, 7, 50, 30};
		//Integer expected[]={10, 7, 50, 30};
		//assertTrue(list.removeIf(a -> a<0));
		//assertArrayEquals(expected, list.toArray(new Integer[0]));
		
		//list.add(17);
		//list.add(17);
		//assertTrue(list.removeIf(a -> a==17));
		//assertArrayEquals(expected, list.toArray(new Integer[0]));
	}
}
