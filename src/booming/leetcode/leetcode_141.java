package booming.leetcode;

// 141.Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

public class leetcode_141 {
    public boolean hasCycle(ListNode head) {

        if (head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        // 用 &&  不能用 ||
        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) return true; // 快慢指针相等就是环形链表
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return false;
    }
}
