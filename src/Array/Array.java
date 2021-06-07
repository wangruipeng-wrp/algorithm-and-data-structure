package Array;

/**
 * 动态数组
 */
public class Array<E> {

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, Index is illegal.");

        if (index == data.length)
            reszie(2 * data.length);

        if (size >= index)
            System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed, Index is illegal.");
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed, Index is illegal.");
        data[index] = e;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, Index is illegal.");
        E result = data[index];

        System.arraycopy(data, index + 1, data, index, size - index);
        size--;

        if (size != 0 && size == data.length / 4)
            reszie(data.length / 2);

        return result;
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @SuppressWarnings("unchecked")
    private void reszie(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(this.data, 0, newData, 0, size);
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        // 编写你的测试用例
    }
}
