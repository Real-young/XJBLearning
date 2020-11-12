package booming.leetcode;

// 144.Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class leetcode_144 {

    List list = new LinkedList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}
