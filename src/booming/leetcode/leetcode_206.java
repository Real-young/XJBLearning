package booming.leetcode;

public class leetcode_206 {
    public ListNode reverseList(ListNode head) {
        // 递归
        if (head.next == null || head == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

}
