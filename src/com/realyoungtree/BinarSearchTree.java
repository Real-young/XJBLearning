package com.realyoungtree;

// 二叉搜索树

import java.util.Comparator;

public class BinarSearchTree<E> {

    private int size;
    private Node<E> root;
    // 比较器
    private Comparator<E> comparator;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size ++;
            return;
        }

        // 添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                return;
            }
        }

        // 查看添加到哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size ++;
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {

        }
    }


    /*
    *  @return 返回值等于0，代表 e1 e2 相等
    *               大于0， e1 > e2
    *               小于0， e1 < e2
    * */
    private int compare(E e1, E e2) {

        // 用比较器做比较 可选择对象的值等
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        /*
        * 强转
        * 如果没有比较器 则遵循接口
        * 强制对象实现 compareTo
        * */
        return ((Comparable<E>) e1).compareTo(e2);
    }

}
