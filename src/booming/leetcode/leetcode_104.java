package booming.leetcode;

// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int height = 0;
        int levelCount = 1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelCount --;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelCount == 0) {
                height ++;
                levelCount = queue.size();
            }
        }
        return height;
    }
}