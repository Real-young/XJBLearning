package com.realyoung;

// 双端队列   double ended queue

public class Deque<E> {

    private LinkedList2<E> linked = new LinkedList2<E>();

    public int size() {
        return linked.size();
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }

    // 队尾入队
    void enQueueRear(E element) {
        linked.add(element);
    }

    // 队头入队
    void enQueueFront(E element) {
        linked.add(0, element);
    }

    // 队尾出队
    E deQueueRear() {
        return linked.remove(linked.size() - 1);
    }

    // 队头出队
    E deQueueFront() {
        return linked.remove(0);
    }

    // 获取队尾
    E rear() {
        return linked.get(linked.size() - 1);
    }

    // 获取队头
    E front() {
        return linked.get(0);
    }

}
