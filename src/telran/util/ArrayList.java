package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array=(T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
		// or array=(T[]) new Object[DEFAULT_CAPACITY];
	}
	@Override
	public boolean add(T obj) {
		if(size==array.length) {
			reallocate();
		}
		array[size]=obj;
		size++;
		return true;
	}

	private void reallocate() {
		array=Arrays.copyOf(array, array.length * 2);
		
	}
	@Override
	public void add(int index, T obj) {
		if (index<0 || index>size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (obj==null) {
			throw new NullPointerException();
		}
		if (isEqual(obj, obj)==false) {
			throw new IllegalArgumentException();
		}
		if(size==array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index+1, size-index);
		array[index]=obj;
		size++;
				
	}

	@Override
	public T remove(int index) {
		if (index<0 || index>=size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (array[index]==null) {
			throw new UnsupportedOperationException();
		}
		T removed=array[index];
		System.arraycopy(array, index+1, array, index, size-1-index);
		size--;
		return removed;
	}

	@Override
	public T get(int index) {
		if (index<0 || index>=size) {
			throw new IndexOutOfBoundsException(index);
		}
		T res=array[index];
		return res;
	}
	@Override
	public int size() {
		
		return size;
	}
	@Override
	public boolean remove(T pattern) {
		boolean res=false;
		int index=0;
		while(index < size && res==false) {
			if (isEqual(array[index], pattern)) {
				System.arraycopy(array, index+1, array, index, size-1-index);
				size--;
				res=true;
			}
			index++;
		}
		return res;		
		
	}
	//@Override
	//public T[] toArray(T[] array) {
	//	T[] res=array;
	//	if (array.length<=size) {
	//		for (int i=0; i<array.length; i++) {
	//			res[i]=array[i];
	//		}			
	//	}
		
	//		else {
	//			for (int i=0; i<array.length; i++) {
	//				if (i<size)
	//				{res[i]=array[i];}
	//				else res[i]=null;
	//			}
				
	//		}
	
	//	return res;
//}
	@Override
	public T[] toArray(T[] buffer) {
		T[] res = buffer;
		if(buffer.length < size) {
			res = (T[]) Arrays.copyOf(array, size, buffer.getClass());
		} else {
			System.arraycopy(array, 0, res, 0, size );
			if(res.length > size) {
				res[size] = null;
			}
		}
		return res;
	}
	//@Override
	//public T[] toArray(T[] array) {
	//	System.arraycopy(array, 0, array, 0, size);
	//	return array;
	//}
	
	//@SuppressWarnings("unchecked")
	//@Override
	//public T[] toArray(T[] array) {
	//	T[] res=array;
	//	if (array.length<=size) {
	//		res=(T[]) Arrays.copyOf(array, size, array.getClass());
	//	} else {
	//	System.arraycopy(array, 0, res, 0, size);
	//	if (res.length>size) {
	//		res[size]=null;
	//	}
	//	}
	//	return res;
	//}
		
	@Override
	public int indexOf(T pattern) {
		int res=-1;
		int index=0;
		while(index < size && res==-1) {
			if (isEqual(array[index], pattern)) {
				res=index;
			}
			index++;
		}
		return res;
	}
	private boolean isEqual(T object, T pattern) {
		
		return pattern==null ? object==pattern : pattern.equals(object);
	}
	@Override
	public int lastIndexOf(T pattern) {
		int res=-1;
		int index=size-1;
		while(index >= 0 && res==-1) {
			if (isEqual(array[index], pattern)) {
				res=index;
			}
			index--;
		}
		return res;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void sort() {
		//Arrays.sort(array, 0, size);	
		sort((Comparator<T>)Comparator.naturalOrder());
		
	}	
	@Override
	public void sort(Comparator<T> comp) {
		
		Arrays.sort(array, 0, size, comp);  //rewrite
		
		
	//	boolean isSorted = false;
	//        T buf;
	//        while(!isSorted) {
	//            isSorted = true;
	//            for (int i = 0; i < array.length-1; i++) {
	                //if (array[i] > array[i+1]){
	            	//if ((Comparable<T>)array[i].compareTo(array[i+1])>0){	
	//            	if (comp.compare(array[i], array[i+1])>0){
	//                    isSorted = false;
	 //
	//                    buf = array[i];
	//                   array[i] = array[i+1];
	//                    array[i+1] = buf;
	//                }
	//            }
	//        }
	}
	@Override
	public int indexOf(Predicate<T> predicate) {
		int res=-1;
		int index=0;
		while(index < size && res==-1) {
			if (predicate.test(array[index])) {
				res=index;
			}
			index++;
		}
		return res;
	}
	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int res=-1;
		int index=size-1;
		while(index >= 0 && res==-1) {
			if (predicate.test(array[index])) {
				res=index;
			}
			index--;
		}
		return res;
	}
	@Override
	public boolean removeIf(Predicate<T> predicate) {
		int oldSize=size;
		int index=0;
		while (index < size) { 
			
			if (predicate.test(array[index])) {
					
					remove(index);
					
			} else			
			index++;
		}
		
		return oldSize>size;	
	
//	@Override
//	public boolean removeIf(Predicate<T> predicate) {
//		int currentSize=size;
//		int index=0;
//		for (int i=0; i<currentSize; i++) {
//			if (!predicate.test(array[i])) {
//				array[index++]=array[i];
//			}
//		}
//		size=index;
//		return currentSize!=size;
	}
	
			

}
