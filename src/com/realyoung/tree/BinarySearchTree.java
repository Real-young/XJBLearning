package com.realyoung.tree;

// 二叉搜索树

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> extends BinaryTree<E>{

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size ++;
            return;
        }

        // 添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element; // 覆盖
                return;
            }
        }

        // 查看添加到哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size ++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private void remove (Node<E> node) {
        if (node == null) return;
        size--;
        // 度为2
        if (node.hasTowChileren()) {
            Node<E> s = successor(node);
            // 后继节点覆盖 度为2 的节点
            node.element = s.element;
            // 删除后继节点
            node = s;
        }

        // 删除 node  （此时 node 的度必然是 1 或者 0）
        Node<E> replacement = node.left != null ? node.left : node.right;
        // 不为空就是 度为 1
        if (replacement != null) {
            replacement.parent = node.parent;

            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else if (node == node.parent.right) {
                node.parent.right = replacement;
            }

        } else if (node.parent == null) {
            root = null; // 根节点
        } else { // node 是叶子节点 不是根节点 度为0
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right =null;
            }
        }

    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;

            if (cmp < 0) {
                node = node.left;
            }
            if (cmp > 0) {
                node = node.right;
            }
        }
        return node;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }


    public static abstract class Visitor<E> {
        boolean stop;
        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
    }


//    // 前序遍历  根结点 左子树 右子树
//    public void preorderTraversal() {
//        preorderTraversal(root);
//    }
//     private void preorderTraversal(Node<E> node) {
//        if (node == null) return;
//        System.out.println(node.element);
//        preorderTraversal(node.left);
//        preorderTraversal(node.right);
//    }
//
//    // 中序遍历 左子树 根结点 右子树  二叉搜索树遍历出来的结果是升序或者降序
//    public void inorderTraversal(){
//        inorderTraversal(root);
//    }
//    private void inorderTraversal(Node<E> node){
//        if (node == null) return;
//        inorderTraversal(node.left);
//        System.out.println(node.element);
//        inorderTraversal(node.right);
//    }
//
//    // 后序遍历 左子树 右子树 根结点
//    public void postorderTraversal() {
//        postorderTraversal(root);
//    }
//    private void postorderTraversal(Node<E> node) {
//        if (node == null) return;
//        postorderTraversal(node.left);
//        postorderTraversal(node.right);
//        System.out.println(node.element);
//    }
//
//    // 层序遍历
//    public void levelOrderTraversal() {
//        if (root == null) return;
//
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//            System.out.println(node.element);
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//    }


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

//    public boolean isComplete() {
//
//        if (root == null) return false;
//        Queue<Node<E>> queue = new LinkedList<>();
//
//        queue.offer(root);
//        boolean leaf = false; // 标记是否叶子节点
//        while (!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//
//            if (leaf && !node.isLeaf()) {  // 前面的已经是叶子节点 但 后面的不是叶子节点 返回 false
//                return false;
//            }
//
//            if (node.hasTowChileren()) {  // 有两个叶子节点
//                queue.offer(node.left);
//                queue.offer(node.right);
//            } else if (node.left == null && node.right != null) {
//                return false;
//            } else {   // 后面遍历的节点都必须是叶子节点
//                leaf = true;
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//            }
//        }
//        return true;
//    }

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

    // 前驱节点
    public Node<E> predecessor(Node<E> node) {
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
    public Node<E> successor(Node<E> node) {
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


}
