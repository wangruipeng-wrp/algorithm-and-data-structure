package Stack;

import LinkedList.LinkedList;

/**
 * 链表栈
 */
public class LinkedListStack<E> implements IStack<E>{

    private final LinkedList<E> link;

    public LinkedListStack() {
        link = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return link.getSize();
    }

    @Override
    public boolean isEmpty() {
        return link.isEmpty();
    }

    @Override
    public void push(E e) {
        link.add(0, e);
    }

    @Override
    public E pop() {
        return link.remove(0);
    }

    @Override
    public E peek() {
        return link.get(0);
    }

    @Override
    public String toString(){
        return "Stack: top " + link;
    }
}
