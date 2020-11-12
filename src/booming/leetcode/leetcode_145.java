package booming.leetcode;

// 145. Binary Tree Postorder Traversal
// https://leetcode.com/problems/binary-tree-postorder-traversal/
import java.util.LinkedList;
import java.util.List;

public class leetcode_145 {

    List list = new LinkedList();
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
