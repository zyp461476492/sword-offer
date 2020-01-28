package github.zyp.no4;

import github.zyp.no4.common.ListNode;

/**
 * <h1>面试题24：反转链表</h1>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Problem24 {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (newHead == null) {
                newHead = p;
                newHead.next = null;
            } else {
                p.next = newHead;
                newHead = p;
            }
            p = next;
        }
        return newHead;
    }

}
