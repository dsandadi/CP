/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;

/**
 *
 * @author DINESH
 */
public class Deque<Item> implements Iterable< Item> {

    private Node front;
    private Node back;

    /**
     * @param args the command line arguments
     */
    private class Node {

        Item item;
        Node next;
    }

    public Deque() {
        front = null;
        back = null;
    }

    public boolean isEmpty() {
        if ((front == null) && (back == null)) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(Item item) {

        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        Node oldFront = front;

        front = new Node();

        front.item = item;

        front.next = oldFront;

        if (oldFront == null) {
            back = front;
        }
    }

    public void addLast(Item item) {

        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        Node oldBack = back;
        back = new Node();
        back.item = item;
        back.next = null;

        if (oldBack != null) {
            oldBack.next = back;
        } else {
            front = back;
        }

    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = front.item;
        front = front.next;
        if(front == null) back = front;
        return item;

    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Node test = front;
        
        while (test.next != back) {
            test = test.next;
            if(test == null) break;
        }

        Item item = back.item;

        back = test;
        if(back == null ) front = back;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public int size() {
        if(isEmpty()) return 0;
        int size = 1;
        Node current = front;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

}
