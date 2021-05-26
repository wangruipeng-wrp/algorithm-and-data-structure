package Queue;

/**
 * 循环队列（不浪费一个空间，使用size变量）
 */
public class LoopQueueWithSize<T> implements IQueue<T> {

    private T[] array;
    private int front, tail;
    private int size;

    public LoopQueueWithSize(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueWithSize() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        if (size == array.length)
            resize(array.length * 2);

        array[tail] = e;
        size++;
        tail = (tail + 1) % array.length;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        T result = array[front];
        array[front] = null;
        front = (front + 1) % array.length;

        if (size == array.length / 4)
            resize(array.length / 2);

        size--;
        return result;
    }

    @Override
    public T getFront() {
        return array[front];
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i <= size; i++)
            newArray[i] = array[(front + i) % array.length];
        front = 0;
        tail = size;
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue: front [");
        for (int i = 0; i != tail; i++) {
            res.append(array[(front + i) % array.length]);
            if ((front + i) % array.length != tail - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
