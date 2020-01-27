package github.zyp.no4;

import github.zyp.no4.common.ListNode;

/**
 * <h1>面试题23：链表中环的入口节点</h1>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * <p>
 * 思路：
 * 快慢指针
 * 第一步，用快慢指针判断是否存在环，快指针一次走两步，慢指针一次走一步
 * 第二步，用双指针找到环的入口，如果环有 n 个节点，则快指针先移动 n 步
 * 第三步，环的长度判断，用快慢指针判断是否为环时，如果相遇，则一定在环中，
 * 从这个位置开始移动，并计数，当回到相遇节点时，则长度就是环的长度
 */
public class Problem23 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) return null;
        // 获取环长度
        int count = 1;
        ListNode countNode = meetingNode;
        while (countNode.next != meetingNode) {
            count++;
            countNode = countNode.next;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        // 先移动 p1 ，移动长度为 count
        while (count > 0) {
            p1 = p1.next;
            count--;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode meetingNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head.next;
        if (slow == null) return null;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            // 快指针移动两步
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }
}
