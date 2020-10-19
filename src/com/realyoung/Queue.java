package com.realyoung;

public class Queue<E>{
    LinkedList2<E> list = new LinkedList2<E>();

    public int size () {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队
    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }

}

