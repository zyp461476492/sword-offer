package github.zyp.no4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <h1>面试题6：从头到尾打印链表</h1>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Problem6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
