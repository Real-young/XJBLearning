package booming.leetcode;

// 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/

public class leetcode_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}
