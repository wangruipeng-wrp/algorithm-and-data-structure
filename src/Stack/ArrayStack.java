package Stack;

import Array.Array;

/**
 * 数组栈
 */
public class ArrayStack<T> implements IStack<T>{

    private final Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<T>(capacity);
    }

    public ArrayStack() {
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
    public void push(T e) {
        array.add(array.getSize() - 1, e);
    }

    @Override
    public T pop() {
        return array.remove(array.getSize()-1);
    }

    @Override
    public T peek() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
