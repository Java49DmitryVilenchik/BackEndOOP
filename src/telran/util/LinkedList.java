package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class LinkedList<T> implements List<T> {
	Node<T> head;
	Node<T> tail;
	int size;
	private static class Node<T> {
		T obj;
		Node<T> next;
		Node<T> prev;
		Node(T obj) {
			this.obj=obj;
		}
	}
	
	@Override
	public boolean add(T obj) {
		add(size, obj);
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public T[] toArray(T[] arr) {
		if(arr.length < size) {
			arr = Arrays.copyOf(arr, size);
		} 
		Node<T> current=head;
		int index=0;
		while(current !=null) {
			arr[index++]=current.obj;
			current=current.next;
		}
		if (arr.length>size) {
			arr[size]=null;
		}
		return arr;
	}

	@Override
	public void add(int index, T obj) {
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException(index);
		}
		Node<T> node=new Node<T>(obj);
		addNode(index, node);
	//	add(index, obj);
	}
	
	@Override
	public T remove(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException(index);
		}
				
		//return delNode(index, getNode(index));
		return delNode(getNode(index));
	}

	@Override
	public T get(int index) {
		if (index <0 || index>=size) {
			throw new IndexOutOfBoundsException(index);
		}
		
		return getNode(index).obj;
	}

	@Override
	public int indexOf(T pattern) {
		int res=-1;
		int index=0;
		while(index < size && res==-1) {
			if (getNode(index).obj==pattern) {
				res=index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res=-1;
		int index=size-1;
		while(index >= 0 && res==-1) {
			if (getNode(index).obj==pattern) {
				res=index;
			}
			index--;
		}
		return res;	
	}

	@Override
	public void sort() {
		// no implement

	}

	@Override
	public void sort(Comparator<T> comp) {
		// no implement

	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		Node<T> current=head;
		int res=-1;
		for(int i=0;i<size && predicate !=null;i++) {
			if (predicate.test(current.obj)) {
				res=i;
				break;
			}
			current=current.next;
		}
		return res;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		Node<T> current=tail;
		int res=-1;
		for(int i=size-1;i>=0 && predicate !=null;i--) {
			if (predicate.test(current.obj)) {
				res=i;
				break;
			}
			current=current.prev;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		Node<T> current=head;
		int oldSize=size;
		while(current !=null && predicate !=null) {
			if (predicate.test(current.obj)) {
				Node<T> temp=current.next;
				delNode(current);
				current=temp;
			} else {
				current=current.next;
			}
		}
		return oldSize>size;
	}
	private void addNode(int index, Node<T> node) {
		if (head==null) // or size==0
			{
			head=tail=node;
		} else {
			if (index==0) {
				addNodeHead(node);
			} else if (index==size) {
				addNodeTail(node);
			} else {
				addNodeMiddle(index, node);
			}
		}
		size++;
	}
	private void addNodeHead(Node<T> node) {
		node.next=head;
		head.prev=node;
		head=node;
	}
	private void addNodeTail(Node<T> node) {
		node.prev=tail;
		tail.next=node;
		tail=node;
	}
	private void addNodeMiddle (int index, Node<T> node) {
		Node<T> nodeA=getNode(index);
		Node<T> nodeBefore=nodeA.prev;
		node.prev=nodeBefore;
		node.next=nodeA;
		nodeBefore.next=node;
		nodeA.prev=node;
	}

	private Node<T> getNode(int index) {
		
		return index > size / 2 ? getNodeFromRight(index) 
				: getNodeFromLeft(index);
	}

	private Node<T> getNodeFromLeft(int index) {
		Node<T> current=head;
		for (int i=0; i<index; i++) {
			current=current.next;
		}
		return current;
	}

	private Node<T> getNodeFromRight(int index) {
		// TODO Auto-generated method stub
		Node<T> current=tail;
		for (int i=size-1; i>index; i--) {
			current=current.prev;
		}
		return current;
	}
	
	private T delNode (Node<T> node) {
		if (head==tail) // or size==0
		{
		head=tail=null;	
		//head=null;
		//tail=null;
		//size=0;
		
	} else if (node==head) {
			delNodeHead();
		} else if (node==tail) {
			delNodeTail();
		} else {
			delNodeMiddle(node);
		}
	
	size--;
	return node.obj;
}
	private void delNodeHead() {
		head=head.next;
		if (head!=null) {head.prev=null;}
		
	}

	private void delNodeTail() {
		tail=tail.prev;
		if (tail!=null) {tail.next=null;}
		
	}
	private void delNodeMiddle (Node<T> node) {
		Node<T> nodeBefore=node.prev;
		Node<T> nodeA=node.next;
		nodeBefore.next=nodeA;		
		nodeA.prev=nodeBefore;
		
		node.next=null;
		node.prev=null;
		
		//Node<T> nodeA=getNode(index);
		//Node<T> nodeBefore=nodeA.prev;
		//node.prev=nodeBefore;
		//node.next=nodeA;
		//nodeBefore.next=node;
		//nodeA.prev=node;
	}
}
