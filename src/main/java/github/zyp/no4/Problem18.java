package github.zyp.no4;

import github.zyp.no4.common.ListNode;

/**
 * <h1>面试题18：删除链表的节点</h1>
 * o(1)的时间复杂度删除该节点
 * <p>
 * 思路：
 * 将后一个节点的值复制到当前节点，然后进行删除
 * 注意问题
 * 1.只有一个节点，则删除后头结点为空
 * 2.是最后一个节点，则需要顺序找到当前节点
 * 3.
 */
public class Problem18 {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null)
            return null;

        //注意备用头结点，头结点可能被删除
        ListNode first = new ListNode(-1);

        first.next = pHead;
        ListNode p = pHead;
        //前节点
        ListNode preNode = first;

        while (p != null && p.next != null) {

            if (p.val == p.next.val) { //两节点相等

                int val = p.val; //记录val用于判断后面节点是否重复
                while (p != null && p.val == val) {   //这一步用于跳过相等的节点，用于删除
                    p = p.next;
                }
                preNode.next = p; //删除操作，前节点的next直接等于现在的节点，把中间的节点直接跨过
            } else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }


    public void deleteNode(ListNode head, ListNode target) {
        if (head == null || target == null) return;

        if (head == target) {
            head = null;
            return;
        }

        if (target.next == null) {
            // 要删除的节点是尾节点，需要循序查找
            ListNode p = head;
            while (p != null && p.next != target)
                p = p.next;
            if (p != null) {
                p.next = null;
            }
            return;
        }

        // 删除该节点后面节点即可
        target.val = target.next.val;
        target.next = target.next.next;
    }
}
