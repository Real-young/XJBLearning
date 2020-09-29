package com.realyoung;

public class LinkedList2<E> extends AbstractList<E> {
//    private int size;
    private Node firstNode;
    private Node lastNode;
    // private class
    private static class Node<E> {
        E element;
        // 后继
        Node<E> nextNode;
        // 前驱
        Node<E> prevNode;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prevNode = prev;
            this.element = element;
            this.nextNode = next;
        }
    }
    private static final int ELEMENT_NOT_FOUND = -1;

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
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
        if (index == size) {
            Node<E> oldLast = lastNode;
            Node<E> last = new Node<>(oldLast, element,null);
            if (oldLast.nextNode == null) {
                firstNode = lastNode;
            } else {
                oldLast.nextNode = last;
            }
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prevNode;
            Node<E> node = new Node<>(prevNode, element, nextNode);
            nextNode.prevNode = node;

            if (node.prevNode == null) {
                firstNode = node;
            } else {
                prevNode.nextNode = node;
            }
        }

        size ++;
    }

    @Override
    public E remove(int index) {

        rangeCheck(index);

        Node<E> node = node(index);
//        node.prevNode.nextNode = node.nextNode;
//        node.nextNode.prevNode = node.prevNode;
        Node<E> prev = node.prevNode;
        Node<E> next = node.nextNode;
        if (prev == null) { // index = 0
            firstNode = next;
        } else {
            prev.nextNode = next;
        }

        if (next == null) { // index = size - 1
            lastNode = prev;
        } else {
            next.prevNode = prev;
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

        if (index < (size >> 1)) {
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
            return node;
        } else {
            Node<E> node = lastNode;
            for (int i = size - 1; i > index; i--) {
                node = node.prevNode;
            }
            return node;
        }
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
