package Queue;

/**
 * 链表队列
 */
public class LinkedListQueue<E> implements IQueue<E>{

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
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
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e, null);
            head = tail;
        } else {
            tail.next = new Node(e, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node res = head;
        head = head.next;
        if (head == null) tail = null;
        res.next = null;
        size--;

        return res.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return tail.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front [");

        for (Node cur = head; cur.next != null; cur = cur.next)
            res.append(res).append("->");

        res.append("] tail");
        return res.toString();
    }
}
