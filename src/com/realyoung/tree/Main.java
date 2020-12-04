package com.realyoung.tree;


import com.realyoung.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        System.out.println("helloworld");

        test3();
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

    static void test3() {
        Integer data[] = new Integer[] {
//                45, 79, 9, 100, 13, 31, 77, 91, 22, 27, 95, 98, 7, 84, 57, 49, 55, 78, 16, 38
                85,19,69,3,7,99,95
        };


        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }

        BinaryTrees.println(avl);

        avl.remove(99);
        BinaryTrees.println(avl);

        avl.remove(85);
        BinaryTrees.println(avl);

        avl.remove(95);
        BinaryTrees.println(avl);
    }


}
