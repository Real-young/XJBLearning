package com.realyoung;
// 单向循环链表
public class SingleCircleLinkedList<E> extends AbstractList<E>{

    private Node firstNode;

    public class Node<E> {
        E element;
        Node<E> nextNode;
        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

    }

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
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> newFirst = new Node<E>(element, firstNode);

            // 取出最后一个节点指向第一个节点
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.nextNode = newFirst;
            firstNode = newFirst;

        } else {
            Node<E> prev = node(index - 1);
            Node<E> node = new Node<E>(element, prev.nextNode);
            prev.nextNode = node;
        }
        size ++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        if (index == 0) {
            if (size == 1) {
                firstNode = null;
            } else {
                Node<E> lastNode = node(size - 1);
                firstNode = firstNode.nextNode;
                lastNode.nextNode = firstNode;
            }
        } else {
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

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (element == node.element) return i;
                node = node.nextNode;
            }
        } else {
            for (int i = 0; i< size; i++) {
                if (element.equals(node.element)) return i;
                node = node.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
    }



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
