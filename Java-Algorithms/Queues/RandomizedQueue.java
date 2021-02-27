import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 *
 * @author DINESH
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] data;
    private int N = 0;

    public RandomizedQueue() {
        data = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        if (N == data.length) {
            resize(2 * data.length);
        }
        data[N++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        int randomPos = StdRandom.uniform(N);
        Item item = data[randomPos];
        data[randomPos] = data[--N];
        data[N] = null;
        if ((N == data.length / 4) && (N > 0)) {
            resize(data.length / 2);
        }
        return item;

    }

    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int randomPos = StdRandom.uniform(N);
        Item item = data[randomPos];
        return item;
    }

    private void resize(int a) {
        Item[] newArray = (Item[]) new Object[a];
        for (int i = 0; i < N; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public Iterator<Item> iterator() {
        return new SandadiIterator();
    }

    private class SandadiIterator implements Iterator<Item> {

        private RandomizedQueue<Item> coll = new RandomizedQueue<Item>();

        SandadiIterator() {
            for (int i = 0; i < N; i++) {
                coll.enqueue(data[i]);
            }
        }

        public boolean hasNext() {
            return !coll.isEmpty();
        }

        public Item next() {
            if (coll.isEmpty()) {
                throw new java.util.NoSuchElementException();
            }
            return coll.dequeue();
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
