package github.zyp.no4;

import github.zyp.no4.common.ListNode;

import java.util.Stack;

/**
 * <h1>面试题52：两个链表的第一个公共节点</h1>
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 例:
 * 1->2->3 --
 * -->6 ---> 7 -->8
 * 4->5 --
 * <p>
 * 思路，公共节点都在尾部，如果从尾部开始往前找，最后一个相同的就是所求节点
 * “先进后出” 符合栈
 * <p>
 * 思路1：
 * 利用两个栈，然后比较栈顶是否相同，直到两个栈顶不同
 * 思路2：
 * 求栈的长度，然后求两个栈长度差，长的栈先走长度差，达到统一起跑线，然后比较
 */
public class Problem52 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        return coreV1(pHead1, pHead2);
    }

    public ListNode coreV2(ListNode p, ListNode q) {
        int lenP = getLength(p);
        int lenQ = getLength(q);
        int sub = 0;
        ListNode needProcessHead = null;
        ListNode otherHead = null;
        if (lenP > lenQ) {
            sub = lenP - lenQ;
            needProcessHead = p;
            otherHead = q;
        } else {
            sub = lenQ - lenP;
            needProcessHead = q;
            otherHead = p;
        }

        while (sub > 0) {
            needProcessHead = needProcessHead.next;
            sub--;
        }

        while (needProcessHead != null && otherHead != null) {
            if (needProcessHead == otherHead) {
                return needProcessHead;
            }
            needProcessHead = needProcessHead.next;
            otherHead = otherHead.next;
        }
        return null;
    }

    private int getLength(ListNode p) {
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    public ListNode coreV1(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode sameNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() != stack2.peek())
                break;
            sameNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }

        return sameNode;
    }
}
