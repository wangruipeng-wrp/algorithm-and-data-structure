package Queue;

/**
 * 队列接口
 */
public interface IQueue<T> {
    int getSize();

    boolean isEmpty();

    void enqueue(T e);

    T dequeue();

    T getFront();
}
