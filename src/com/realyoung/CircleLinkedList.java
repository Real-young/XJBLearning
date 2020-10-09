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

    }

    @Override
    public E remove(int index) {
        return null;
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
}
