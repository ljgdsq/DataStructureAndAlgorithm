package main.com.zsl.algorithm.compoment;

import java.util.Iterator;

public class LinkedList<T> implements Iterable {

    public LinkedList() {
        this.head = new Node(null, null);
        this.last = null;
    }

    private static class Node<T> {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public Iterator iterator() {
        return new ListIterator(head);
    }

    private Node head;

    private Node last;

    public boolean insert(T data) {
        if (last == null) {
            last = new Node(data, null);
            head.next = last;
        } else {
            Node item = new Node(data, null);
            last.next = item;
            last = item;
        }
        return true;
    }


    public void reverse() {
        if (head.next==null)
            return;

        reverse(head.next);

    }


    private Node reverse(Node current) {
        if (current.next == null) {
            head.next=current;
            return current;
        } else {
            Node item=reverse(current.next);
            item.next=current;
            current.next=null;
            return current;
        }
    }

    private static class ListIterator implements Iterator {
        private Node current;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Object next() {
            current = current.next;
            return current.data;
        }

        public ListIterator(Node current) {
            this.current = current;
        }
    }

}
