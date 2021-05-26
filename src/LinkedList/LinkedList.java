package LinkedList;

/**
 * 链表
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private final Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, index is illegal");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed, index is illegal");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed, index is illegal");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }

        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, remove is illegal");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;

        return del.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur.next != null; cur = cur.next)
            res.append(cur.e).append("->");
        res.append("NULL");
        return res.toString();
    }

}
