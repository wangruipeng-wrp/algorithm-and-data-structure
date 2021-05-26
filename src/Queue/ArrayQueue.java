package Queue;

import Array.Array;

/**
 * 数组队列
 */
public class ArrayQueue<T> implements IQueue<T> {

    private final Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<T>(capacity);
    }

    public ArrayQueue() {
        array = new Array<T>(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        array.add(array.getSize() - 1, e);
    }

    @Override
    public T dequeue() {
        return array.remove(0);
    }

    @Override
    public T getFront() {
        return array.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayQueue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
