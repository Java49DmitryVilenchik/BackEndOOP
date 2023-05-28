package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import telran.util.*;

class HashSetTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		
		return new HashSet<>(3);
	}

}
