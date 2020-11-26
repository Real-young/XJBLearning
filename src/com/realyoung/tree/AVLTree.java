package com.realyoung.tree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    private static class AVLNode<E> extends Node<E> {
        int height;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;

            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }
    }

    @Override
    protected void afterAdd(Node<E> node) {

        while ((node = node.parent) != null) {
            if (isBalanced(node)) {   // 这计算 小于等于1 就是平衡
                // 更新高度
                updateHeight(node);
            } else { // 不平衡则旋转

            }
        }

    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }
}
