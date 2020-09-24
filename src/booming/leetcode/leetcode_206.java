package booming.leetcode;

public class leetcode_206 {
    public ListNode reverseList1(ListNode head) {
        // 递归
        if (head.next == null || head == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public ListNode reverseList2(ListNode head) {
        // 迭代
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            // 复制到新的链表中
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
