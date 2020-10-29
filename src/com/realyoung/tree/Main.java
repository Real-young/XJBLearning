package com.realyoung.tree;

import com.realyoung.printer.BinaryTrees;
//import com.realyoung.BinarySearchTree.Visitor;
//import com.realyoung.file.Files;
import com.realyoung.printer.BinaryTreeInfo;
public class Main {
    public static void main(String[] args) {
        System.out.println("helloworld");

        test1();

    }

    static void test1() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);


    }


}
