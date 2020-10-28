package stack;

import com.realyoung.linklist.ArrayList;

public class Stack<E> {

    private ArrayList<E> list = new ArrayList<E>();

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
