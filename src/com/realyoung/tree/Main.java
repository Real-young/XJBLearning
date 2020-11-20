package com.realyoung.tree;

import booming.leetcode.TreeNode;
import booming.leetcode.leetcode_102;
import com.realyoung.printer.BinaryTrees;
import com.realyoung.tree.BinaryTree.Visitor;
//import com.realyoung.file.Files;
import com.realyoung.printer.BinaryTreeInfo;
public class Main {
    public static void main(String[] args) {
        System.out.println("helloworld");

        test2();
    }

    static void test1() {
        Integer data[] = new Integer[] {
//                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
                7, 4, 9, 2, 5
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
//        System.out.println(bst);
        System.out.println(bst.height());
        System.out.println(bst.isComplete());

//        bst.preorderTraversal(new Visitor<Integer>() {
//
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print("_" + element + "_ ");
//                return false;
//            }
//        });

//        bst.inorderTraversal();

//        bst.postorderTraversal();

//        bst.levelOrderTraversal();

    }

    static void test2() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(7);
        BinaryTrees.println(bst);
    }



}
