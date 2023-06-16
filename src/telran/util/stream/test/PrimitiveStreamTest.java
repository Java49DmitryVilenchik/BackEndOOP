package telran.util.stream.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.HashSet;
import telran.util.stream.PrimitiveStreams;

import static telran.util.stream.PrimitiveStreams.*;

import java.util.Arrays;

class PrimitiveStreamTest {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 2_000_000_000;
	private static final int N_NUMBERS = 1000;
	private static final int N_RUNS = 100;

	@Test
	void uniqueRandomTest() {
		int[] arrayPrev = randomUnique(N_NUMBERS, MIN_NUMBER, MAX_NUMBER);
		runUniqueTest(arrayPrev);
		for (int i = 0; i < N_RUNS; i++) {
			int[] arrayNext = randomUnique(N_NUMBERS, MIN_NUMBER, MAX_NUMBER);
			runUniqueTest(arrayNext);
			runArrayNotEqualTest(arrayPrev, arrayNext);
			arrayPrev = arrayNext;

		}
	}

	private void runArrayNotEqualTest(int[] arrayPrev, int[] arrayNext) {

		int index = 0;
		if (arrayPrev.length == arrayNext.length) {
			while (index < arrayPrev.length && arrayPrev[index] == arrayNext[index]) {
				index++;
			}
		}
		assertTrue(index < arrayPrev.length);

	}

	private void runUniqueTest(int[] array) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : array) {
			set.add(num);
		}
		assertEquals(array.length, set.size());

	}
	@Test
	void shuffleTest() {

        // Тест 1: Проверка перемешивания массива
        int[] array = {10, 20, 30, 40, 50};
        int[] shuffled = PrimitiveStreams.shuffle(array);
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Shuffled array: " + Arrays.toString(shuffled));

        // Тест 2: Проверка сохранения всех элементов массива
        int[] array2 = {10, 20, 30, 40, 50};
        int[] shuffled2 = PrimitiveStreams.shuffle(array2);
        Arrays.sort(array2);
        Arrays.sort(shuffled2);
        System.out.println("Original array: " + Arrays.toString(array2));
        System.out.println("Shuffled array: " + Arrays.toString(shuffled2));

        // Тест 3: Проверка на пустой массив
        int[] array3 = {};
        int[] shuffled3 = PrimitiveStreams.shuffle(array3);
        System.out.println("Original array: " + Arrays.toString(array3));
        System.out.println("Shuffled array: " + Arrays.toString(shuffled3));
	}
	@Test
	void shuffleTest1() {
		int[] array = randomUnique(N_NUMBERS, MIN_NUMBER, MAX_NUMBER);
		int[] arrayShuffled=PrimitiveStreams.shuffle(array);
		assertNotEquals(array, arrayShuffled);
		assertEquals(array.length, arrayShuffled.length);
		Arrays.sort(array);
		Arrays.sort(arrayShuffled);
		assertArrayEquals(array, arrayShuffled);
	}
}


