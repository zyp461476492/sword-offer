package github.zyp.no4;

import github.zyp.no4.common.TreeLinkNode;

/**
 * <h1>面试题8：二叉树的下一个节点</h1>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 思路：
 * 1.如果一个节点有右子树，则它的下一个节点是右子树的最左节点
 * 2.如果一个节点没有右子树，如果该节点是它父节点的左子节点，那么它的下一个节点就是他的父节点
 * 3.如果一个节点没有右子树，且是父节点的右子节点，
 * 则情况复杂，需要一直向上查找，直到找到一个节点是它父节点的左子节点，就是我们需要找到的下一个节点
 */
public class Problem8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else if (pNode.next != null) {
            TreeLinkNode current = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && current == pParent.right) {
                current = pParent;
                pParent = pParent.next;
            }

            return pParent;
        }
        return null;
    }
}
