package github.zyp.no4;

import github.zyp.no4.common.ListNode;

/**
 * <h1>面试题22：链表中倒数第 K 个节点</h1>
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 我的思路
 * 遍历两边，第一遍遍历找到长度
 * 第二遍找到 LEN - K + 1 个节点即可
 * 一边遍历思路
 * 双指针法：一个指针先指向 k - 1 的位置，第二个指针从头
 * 开始移动这两个指针，当第一个指针到达尾节点时，第二个指针就是目标指针
 */
public class Problem22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode p = head;
        ListNode q = head;

        for (int i = 1; i < k; i++) {
            if (p.next != null)
                p = p.next;
            else
                // count < k
                return null;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
