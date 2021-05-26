package Stack;

/**
 * 栈接口
 */
public interface IStack<T> {

    int getSize();

    boolean isEmpty();

    void push(T e);

    T pop();

    T peek();
}
