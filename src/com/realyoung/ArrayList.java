package com.realyoung;
// 动态数组
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E>{
    // 数组长度
//    private int size;

    // 所有的元素
    private E[] elements;

    // 默认长度 10
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(int capacity) {
        // 比默认小取默认  否则 取传参
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    // 获取 index 的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // set
    public E set(int index, E element) {
        rangeCheck(index);
        // 取出旧的
        E old = elements[index];
        // 设置新的元素
        elements[index] = element;
        // 把旧元素返回出去
        return old;
    }

    // 查看元素的索引
    public int indexOf(E element) {
        // 空值处理
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 清除所有的元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // 往一个位置添加一个元素
    public void add(int index, E element) {
        //rangeCheckForAdd(index);
        // 调用扩容
        ensureCapacity(size + 1);

        for(int i = size-1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size ++ ;

    }

    // 删除某个位置的元素
    public E remove(int index) {

        rangeCheck(index);

        E oldElement = elements[index];
        // 遍历删除的元素的后一位到末位
        for (int i = index + 1; i < size - 1; i++) {
            // 当前的 放到 前一位
            elements[i - 1] = elements[i];
        }
        // size 先减去一位
        elements[--size] = null;
        return oldElement;
    }

    // 缩容
    private void trim() {
        int capacity = elements.length;
        if (size >= (capacity) || capacity <= DEFAULT_CAPACITY) return;

        int newCapacity = capacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;

    }


    // 重写 toString 方法
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

    // 扩容 保证容量足够
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 扩容 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        // 内存重新指向
        elements = newElements;


        System.out.println("扩容前" + oldCapacity + "扩容后" + newCapacity);
    }

}
