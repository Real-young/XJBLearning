package com.realyoung;

public class CircleLinkedList<E> extends AbstractList<E> {

    private Node firstNode;
    private Node lastNode;

    public class Node<E> {
        E element;
        Node<E> nextNode;
        Node<E> prevNode;
        public Node(E element, Node<E> nextNode, Node<E> prevNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }

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
        E old = node(index).element;
        node(index).element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            // 取出最后一个  然后替换
            Node<E> oldLast = lastNode;
            // 新插入一个节点  new 一个
            Node<E> node = new Node<>(element, firstNode, oldLast);
            if (oldLast == null) {
                firstNode = lastNode;
                firstNode.prevNode = firstNode;
                firstNode.nextNode = firstNode;
            } else {
                oldLast.nextNode = node;
                firstNode.prevNode = node;
            }
        } else  {
            Node<E> nextNode = node(index);
            Node<E> node = new Node<>(element,nextNode,nextNode.prevNode);
            nextNode.prevNode = node;
            nextNode.prevNode.nextNode = node;

            if (nextNode == firstNode) { // index = 0 的时候
                firstNode = node;
            }

        }

        size ++;
    }

    @Override
    public E remove(int index) {

        Node<E> node = node(index);
        Node<E> next = node.nextNode;
        Node<E> prev = node.prevNode;
        if (prev == null) {
            firstNode = next;
        } else {
            prev.nextNode = next;
        }

        if (next == null) {
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
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node(i) == null) return i;
                node = node.nextNode;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node(i).element)) return i;
                node = node.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

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
