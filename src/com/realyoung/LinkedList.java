package com.realyoung;
// 单向链表
public class LinkedList<E> extends AbstractList<E> {
//    private int size;
    private Node firstNode;

    // private class
    private static class Node<E> {
        E element;
        // 后继
        Node<E> nextNode;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.nextNode = next;
        }
    }
    private static final int ELEMENT_NOT_FOUND = -1;

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
    }


    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;

    }

    @Override
    public void add(int index, E element) {

        if (index == 0) {
            // first 节点会变成第二个节点
            firstNode = new Node<E>(element, firstNode);
        } else {
            Node<E> prev = node(index - 1);
            // 添加节点
            prev.nextNode = new Node<E>(element, prev.nextNode);
        }
        size ++;
    }

    @Override
    public E remove(int index) {

        Node<E> node = firstNode;
        if (index == 0) {
            firstNode = firstNode.nextNode;
        } else {
            // 拿到前面的节点
            Node<E> prev = node(index - 1);
            node = prev.nextNode;
            prev.nextNode = prev.nextNode.nextNode;
        }
        size --;

        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode;
        // 空值处理
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node(i).element == null) return i;
                node = node.nextNode;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node(i).element)) {
                    return i;
                }
                node = node.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 获取 index 位置对应的节点对象
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        return node;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        Node<E> node = firstNode;
        for(int i = 0; i < size; i++) {
            if (i!=0) string.append(", ");
            string.append(node.element);
            node = node.nextNode;
        }
        string.append("]");
        return string.toString();
    }
}
