package com.realyoung;

public class CircleLinkedList<E> extends AbstractList<E> {

    private Node firstNode;
    private Node lastNode;

    // 约瑟夫问题
    private Node currentNode;


    public class Node<E> {
        E element;
        Node<E> nextNode;
        Node<E> prevNode;
        public Node(E element, Node<E> nextNode, Node<E> prevNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prevNode != null) {
                sb.append(prevNode.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (nextNode != null) {
                sb.append(nextNode.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
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
        rangeCheckForAdd(index);
        if (index == size) {
            // 取出最后一个  然后替换
            Node<E> oldLast = lastNode;
            // 新插入一个节点  new 一个
            lastNode = new Node<>(element, firstNode, oldLast);
            if (oldLast == null) {
                firstNode = lastNode;
                firstNode.prevNode = firstNode;
                firstNode.nextNode = firstNode;
            } else {
                oldLast.nextNode = lastNode;
                firstNode.prevNode = lastNode;
            }
        } else  {
            Node<E> nextNode = node(index);
            Node<E> prev = nextNode.prevNode;
            Node<E> node = new Node<>(element,nextNode,nextNode.prevNode);
            nextNode.prevNode = node;
            prev.nextNode = node;

            if (nextNode == firstNode) { // index = 0 的时候
                firstNode = node;
            }

        }

        size ++;
    }

//    @Override
//    public E remove(int index) {
//
//        Node<E> node = firstNode;
//        if (size == 1) {
//            firstNode = null;
//            lastNode = null;
//        } else {
//            node = node(index);
//            Node<E> next = node.nextNode;
//            Node<E> prev = node.prevNode;
//
//            prev.nextNode = next;
//            next.prevNode = prev;
//            if (node == firstNode) {
//                firstNode = next;
//            }
//
//            if (node == lastNode) {
//                lastNode = prev;
//            }
//        }
//        size --;
//
//        return node.element;
//    }


    @Override
    public E remove(int index) {

        rangeCheck(index);
        return remove(node(index));
    }

    private E remove(Node<E> node) {
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {

            Node<E> prev = node.prevNode;
            Node<E> next = node.nextNode;
            prev.nextNode = next;
            next.prevNode = prev;

            if (node == firstNode) {
                firstNode = next;
            }
            if (node == lastNode) {
                lastNode = prev;
            }
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

    public void reset() {
        currentNode = firstNode;
    }

    public E next() {
        if (currentNode == null) return null;
        currentNode = currentNode.nextNode;
        return (E) currentNode.element;
    }

    public E remove() {
        if (currentNode == null) return null;
        Node<E> next = currentNode.nextNode;
        E element = (E) remove(currentNode);
        if (size == 0) {
            currentNode = null;
        } else {
            currentNode = next;
        }
        return element;
    }


}
