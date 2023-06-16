package telran.util.stream;

import java.util.Random;
import java.util.Arrays;

public class PrimitiveStreams {
	static public int[] randomUnique(int nNumbers, int minInclusive,
			int maxExclusive) {
		if (maxExclusive - minInclusive < nNumbers) {
			throw new IllegalArgumentException("impossible to get the given amount of unique random numbers");
		}
		return new Random().ints(minInclusive, maxExclusive)
				.distinct().limit(nNumbers).toArray();
	}
	static public int[] shuffle(int[] array) {

        Random random = new Random();
        return Arrays.stream(array)
                .boxed()
                .map(i -> new int[]{random.nextInt(), i})
                .sorted((a, b) -> Integer.compare(a[0], b[0]))
                .mapToInt(a -> a[1])
                .toArray();
	}
	//В этом примере метод shuffle принимает массив array, преобразует его в Stream с помощью метода Arrays.stream, затем использует метод boxed для преобразования каждого элемента массива в объект Integer.

//Далее каждый элемент пары (случайное_число, элемент_массива) создается с помощью метода map, который принимает текущий элемент и генерирует случайное число с помощью random.nextInt(). Результаты сортируются по случайным числам с помощью метода sorted.

//Затем с помощью mapToInt возвращается исходный тип int, а не Integer, и результат преобразуется обратно в массив с помощью toArray.
	//
	
}

