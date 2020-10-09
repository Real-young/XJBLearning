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
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
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

        if (element == null) {
            for (int i = 0; i < size; i++) {
//                element.equals()
            }
        }
        return 0;
    }

    private Node<E> node(int index) {
        rangeCheck(index);


    }
}
