package com.realyoung;

public class LinkedList<E> extends AbstractList<E> {
    private int size;
    private Node firstNode;

    private static final int ELEMENT_NOT_FOUND = -1;

    @Override
    public void clear() {

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
        return 0;
    }

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
}
