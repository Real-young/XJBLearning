package booming.leetcode;

// 94. Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class leetcode_94 {

    List list = new LinkedList();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return  list;
    }
}
