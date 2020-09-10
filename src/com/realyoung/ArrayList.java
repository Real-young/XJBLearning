package com.realyoung;

public class ArrayList {
    // 数组长度
    private int size;

    // 所有的元素
    private int[] elements;

    // 默认长度 10
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        // 比默认小取默认  否则 取传参
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
}
