package com.realyoung.tree;

import com.realyoung.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected BinaryTree.Node<E> root;

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

    public static abstract class Visitor<E> {
        boolean stop;
        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
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

    // 前驱节点
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        Node<E> p = node.left;

        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点 祖父节点找前驱
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    // 后驱节点
    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;
        Node<E> s = node.right;

        if (s != null) {
            while (s.left != null) {
                s = s.left;
            }
            return s;
        }

        // 从父节点 祖父节点找后驱
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    // 高度
    public int height() {
        return height2(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


    // 判断高度
    private int height2(Node<E> node) {
        if (node == null) return 0;

        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<E> queueNode = queue.poll();
            levelSize--;
            if (queueNode.left != null) {
                queue.offer(queueNode.left);
            }

            if (queueNode.right != null) {
                queue.offer(queueNode.right);
            }

            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }

    // 是否完全二叉树
    public boolean isComplete() {

        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }
        }

        return false;
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
        postorder(root, visitor);

    }
    private void postorder(Node<E> node, BinarySearchTree.Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    // 层序
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }
}
