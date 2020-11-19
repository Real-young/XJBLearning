package com.realyoung.tree;

import com.realyoung.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected BinaryTree.Node<E> root;
    // 比较器
    private Comparator<E> comparator;

    // BinaryTreeInfo implements
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /*
     *  @return 返回值等于0，代表 e1 e2 相等
     *               大于0， e1 > e2
     *               小于0， e1 < e2
     * */
    protected int compare(E e1, E e2) {

        // 用比较器做比较 可选择对象的值等
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        /*
         * 强转
         * 如果没有比较器 则遵循接口
         * 强制对象实现 compareTo
         * */
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        // 判断叶子节点
        public boolean isLeaf() {
            return left == null && right == null;
        }

        // 判断拥有两个子节点
        public boolean hasTowChileren() {
            return left != null && right != null;
        }
    }

    // 2020.10.30 用 Visitor 来控制遍历到二叉树中的哪一个

    // 前序
    public void preorderTraversal(BinarySearchTree.Visitor<E> visitor) {
        if (visitor == null) return;
        preorderTraversal(root, visitor);
    }
    private void preorderTraversal(Node<E> node, BinarySearchTree.Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    // 中序
    public void inorderTraversal(BinarySearchTree.Visitor<E> visitor) {
        if (visitor == null) return;
        inorderTraversal(root, visitor);

    }
    private void inorderTraversal(Node<E> node, BinarySearchTree.Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorderTraversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    // 后序
    public void postorder(BinarySearchTree.Visitor<E> visitor) {
        if (visitor == null) return;

    }
    private void postorder(Node<E> node, BinarySearchTree.Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();

    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        toString(node.left, sb, prefix + "L--");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R--");
    }
}
