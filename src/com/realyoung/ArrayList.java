package com.realyoung;

public class ArrayList {
    // 数组长度
    private int size;

    // 所有的元素
    private int[] elements;

    // 默认长度 10
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        // 比默认小取默认  否则 取传参
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取 index 的元素
    public int get(int index) {
        if (index < 0 || index >= size) {
            // 抛出异常
            throw new IndexOutOfBoundsException("Index"+index + ", Size" + size);
        }
        return elements[index];
    }

    // set
    public int set(int index, int element) {
        if (index < 0 || index >= 0) {
            throw new IndexOutOfBoundsException("Index"+ index + ", Size" + size);
        }
        // 取出旧的
        int old = elements[index];
        // 设置新的元素
        elements[index] = element;
        // 把旧元素返回出去
        return old;
    }

    // 查看元素的索引
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


}
