package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedHashSet<T> implements Set<T> {
    int size;
    private static class Node<T> {
        T obj;
        Node<T> prev;
        Node<T> next;

        Node(T obj) {
            this.obj = obj;
        }
    }
    Node<T> head;
    Node<T> tail;
    HashMap<T, Node<T>> map = new HashMap<>();

    private class LinkedHashSetIterator implements Iterator<T> {
        Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the set");
            }
            T obj = currentNode.obj;
            currentNode = currentNode.next;
            return obj;
        }

        @Override
        public void remove() {
            if (currentNode == null) {
                throw new IllegalStateException("No element to remove");
            }
            Node<T> nodeToRemove = currentNode.prev;
            removeNode(nodeToRemove);           
            map.remove(nodeToRemove.obj);
            size--;
        }
    }

    @Override
    public boolean add(T obj) {
        boolean res = false;
        if (!map.containsKey(obj)) {
            res = true;
            Node<T> node = new Node<>(obj);
            map.put(obj, node);
            addNode(node);
            size++;
        }
        return res;
    }

    private void addNode(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T pattern) {
        boolean res = false;
        Node<T> node = map.get(pattern);
        if (node != null) {
            res = true;
            removeNode(node);
            map.remove(pattern);
            size--;
        }
        return res;
    }

    private void removeNode(Node<T> node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    @Override
    public boolean contains(T pattern) {
        return map.containsKey(pattern);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedHashSetIterator();
    }

    @Override
    public T get(T pattern) {
        Node<T> resNode = map.get(pattern);
        return resNode != null ? resNode.obj : null;
    }
}
