package com.realyoung.tree;

// 二叉搜索树

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> extends BinaryTree<E>{

    // 比较器
    protected Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
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

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element, null);
            size ++;

            afterAdd(root);
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
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size ++;

        afterAdd(newNode);
    }

    // 添加 Node 之后的调整
    protected void afterAdd(Node<E> node) { }

    protected void afterRemove(Node<E> node) { }

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

            // 删除节点之后的调整
            afterRemove(node);

        } else if (node.parent == null) {
            root = null; // 根节点

            afterRemove(node);
        } else { // node 是叶子节点 不是根节点 度为0
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right =null;
            }
            afterRemove(node);
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

}
