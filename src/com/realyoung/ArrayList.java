package com.realyoung;

import java.util.Arrays;

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
        rangeCheck(index);
        return elements[index];
    }

    // set
    public int set(int index, int element) {
        rangeCheck(index);
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

    // 清除所有的元素
    public void clear() {
        size = 0;
    }

    // 默认添加到最后
    public void add(int element) {
        add(size, element);
//        elements[size++] = element;
    }

    // 往一个位置添加一个元素
    public void add(int index, int element) {
        rangeCheckForAdd(index);

        for(int i = size-1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size ++ ;

    }

    // 删除某个位置的元素
    public int remove(int index) {

        rangeCheck(index);

        int old = elements[index];
        // 遍历删除的元素的后一位到末位
        for (int i = index + 1; i < size - 1; i++) {
            // 当前的 放到 前一位
            elements[i-1] = elements[i];
        }
        size --;
        return old;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for(int i = 0; i < size; i++) {
            if (i!=0) string.append(", ");
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index"+ index + ", Size" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


}
