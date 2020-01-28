package github.zyp.no4;

import github.zyp.no4.common.ListNode;

/**
 * <h1>面试题25：合并两个排序的链表</h1>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Problem25 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(1);
        ListNode p = newHead;
        while (list1 != null && list2 != null) {
            ListNode next = null;
            if (list1.val < list2.val) {
                next = list1.next;
                p.next = list1;
                list1 = next;
            } else {
                next = list2.next;
                p.next = list2;
                list2 = next;
            }
            p = p.next;
            p.next = null;
        }

        while (list1 != null) {
            ListNode next = list1.next;
            p.next = list1;
            p = p.next;
            p.next = null;
            list1 = next;
        }

        while (list2 != null) {
            ListNode next = list2.next;
            p.next = list2;
            p = p.next;
            p.next = null;
            list2 = next;
        }
        return newHead.next;
    }
}
