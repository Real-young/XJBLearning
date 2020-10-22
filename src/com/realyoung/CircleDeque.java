package com.realyoung;

// 循环双端队列

public class CircleDeque<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    // 取出真实位置
    private int index(int index) {
        index += front;
        if (index < 0) {
            return elements.length + index;
        }
        return index % elements.length;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量扩充为原来的 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // reset front
        front = 0;
    }

    // 队尾入队
    void enQueueRear(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size ++;
    }

    // 队头入队
    void enQueueFront(E element) {
        ensureCapacity(size + 1);

        front = index(-1);
        elements[front] = element;
        size ++;
    }

    // 队尾出队
    E deQueueRear() {
        int indexRear = index(size -1)
        E rearElement = elements[indexRear];
        elements[indexRear] = null;
        size --;
        return rearElement;
    }

    // 队头出队
    E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size --;
        return frontElement;
    }

    // 获取队尾
    E rear() {
        return elements[index(size -  1)];
    }

    // 获取队头
    E front() {
        return elements[front];
    }

}
