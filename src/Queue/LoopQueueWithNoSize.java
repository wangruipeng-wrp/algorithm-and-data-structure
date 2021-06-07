package Queue;

/**
 * 循环队列（浪费一个空间，没有size变量）
 */
public class LoopQueueWithNoSize<T> implements IQueue<T> {

    private T[] array;
    private int front, tail;

    @SuppressWarnings("unchecked")
    public LoopQueueWithNoSize(int capacity) {
        this.array = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueWithNoSize() {
        this(10);
    }

    @Override
    public int getSize() {
        return (array.length + tail - front) % array.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(T e) {
        if ((tail + 1) % array.length == front)
            resize(array.length * 2 - 1);

        array[tail] = e;
        tail = (tail + 1) % array.length;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        T result = array[front];
        array[front] = null;
        front = (front + 1) % array.length;

        if (getSize() == array.length / 4)
            resize(array.length / 2);

        return result;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot getFront from an empty queue");
        return array[front];
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = array[(front + i) % array.length];
        }
        tail = getSize();
        front = 0;
        array = newData;
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

    public static void main(String[] args) {

    }
}
