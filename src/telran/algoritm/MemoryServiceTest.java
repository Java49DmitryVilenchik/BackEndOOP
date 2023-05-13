package telran.algoritm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.*;

class MemoryServiceTest {
	byte[] array;
	@Test
	@Disabled
	// must disable;
	void test() {
		int size=MemoryService.getMaxAvailableSize2();
		array=new byte[size];
		boolean flException=false;
		try {
			array=null;
			array=new byte[size+1];
		} catch (OutOfMemoryError e) {
		//catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			flException=true;
		}
		assertTrue(flException);
	}
	@Test
	@Disabled
	void allocationMemoryTest() {
		byte[] array;
		Runtime runtime=Runtime.getRuntime();
		for(int i=0; i<10; i++) {
			displayMemoryMap(runtime);
			long freeMemory=runtime.freeMemory();
			int size=freeMemory>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) freeMemory;
			array=new byte[size];
			
		}
	}
	@Test
	void allocationMemoryTestNoGc() {
		List<byte[]> list=new ArrayList<>();
		Runtime runtime=Runtime.getRuntime();
		try {
			while(true) {
				displayMemoryMap(runtime);
				long freeMemory=runtime.freeMemory();
				int size=freeMemory>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) freeMemory;
				list.add(new byte[size]);
			}
		}catch (OutOfMemoryError e) {
			
		}
	}
	private void displayMemoryMap(Runtime runtime) {
		// TODO Auto-generated method stub
		System.out.printf("free memory: %d, total memory: %d, maximal memory: %d\n",
				runtime.freeMemory(), runtime.totalMemory(), runtime.maxMemory());
		
	}
}
