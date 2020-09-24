package booming.leetcode;

// leetcode 237
// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class leetcode_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
