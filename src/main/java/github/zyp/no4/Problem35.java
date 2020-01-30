package github.zyp.no4;

import github.zyp.no4.common.RandomListNode;

/**
 * <h1>面试题35：复杂链表的复制</h1>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 思路：
 * 借助 HashMap
 * K: 原节点 N
 * V：原节点对应的 N'
 * 第一步，复制原节点，按照 next 构建 N'
 * 第二步，找到 N 的 random 对应的 random'，也就是 N'
 * 空间换时间
 * 比较优的解法
 * 不借助辅助空间，利用 O(N) 的时间复杂度来完成。
 * 第一步，依然是根据原始链表的每个节点N创建对应的N'。这里我们把N'挂载N的后面
 * 第二步，设置复制出来节点的 random'，random'就是N'对应N的random节点的 next 节点
 * 第三步，把这个长链表，拆分为两个链表
 */
public class Problem35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        cloneNodes(pHead);
        cloneRandomNode(pHead);
        return reconnectNodes(pHead);
    }

    private RandomListNode cloneNodes(RandomListNode root) {
        RandomListNode p = root;
        while (p != null) {
            RandomListNode clone = new RandomListNode(p.label);
            clone.next = p.next;
            p.next = clone;
            p = clone.next;
        }
        return root;
    }

    private RandomListNode cloneRandomNode(RandomListNode root) {
        RandomListNode p = root;
        while (p != null) {
            RandomListNode cloneNode = p.next;
            if (p.random != null) {
                cloneNode.random = p.random.next;
            }
            p = cloneNode.next;
        }
        return root;
    }

    private RandomListNode reconnectNodes(RandomListNode root) {
        RandomListNode p = root;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if (p != null) {
            cloneHead = p.next;
            cloneNode = cloneHead;
            p.next = cloneNode.next;
            p = p.next;
        }

        while (p != null) {
            cloneNode.next = p.next;
            cloneNode = cloneNode.next;
            p.next = cloneNode.next;
            p = p.next;
        }
        return cloneHead;
    }
}
