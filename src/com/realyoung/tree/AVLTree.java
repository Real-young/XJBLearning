package com.realyoung.tree;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
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

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;

            if (leftHeight > rightHeight) return left;
            if (rightHeight > leftHeight) return right;
            return isLeftChild() ? left : right;

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

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }

    // 恢复平衡
    private void rebalance2 (Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();

        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL

            } else { // LR

            }
        } else { // R
            if (node.isRightChild()) { // RR

            } else { // RL

            }
        }
    }

    private void rebalance (Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();

        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL

            } else { // LR

            }
        } else { // R
            if (node.isRightChild()) { // RR

            } else { // RL

            }
        }
    }
}
