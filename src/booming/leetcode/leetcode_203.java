package booming.leetcode;

// 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/

public class leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {
        // 迭代
        if (head == null || head.next == null) return head;
        while (head.next != null && head.val == val) {
            head = head.next;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
