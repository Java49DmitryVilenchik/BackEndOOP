package telran.algoritm;

public class MemoryService {
public static int getMaxAviableSize() {
		//return 1;
		int res=Integer.MAX_VALUE;
		boolean running=true;
		while (running) {
			try {
				byte[] array=new byte[res];
				running=false;
			} catch (OutOfMemoryError e) {
				//res--;
				res /=2;
			}
		}
		return res;
	}
public static int getMaxAvailableSize1() {
    int left = 0;
    int right = Integer.MAX_VALUE;
    int middle = 0;
    int maxSize = -1;
    
    while (left <= right) {
        middle = (left + right) / 2;
        try {
            byte[] array = new byte[(int) middle];
            maxSize = middle;
            array = null;
            left = middle + 1;
        } catch (OutOfMemoryError e) {
            right = middle - 1;
        }
    }
    return maxSize;
}
public static int getMaxAvailableSize2() {
    int left = 0;
    int right = Integer.MAX_VALUE;
    int middle = right/2;
    int maxSize=0;
   
    
    while (left <= right) {
       
        try {
            byte[] array = new byte[(int) middle];
            maxSize = middle;
           
            left = middle + 1;
        } catch (OutOfMemoryError e) {
            right = middle - 1;
        }
        middle=right/2 + left/2;
    }
    return maxSize;
}
}
