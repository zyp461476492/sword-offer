package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题36：二叉搜索树和双向链表</h1>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 思路：
 * 二叉搜索树中序遍历是有序的
 * TODO java 对象引用
 */
public class Problem36 {

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) return null;
        TreeNode[] lastNode = new TreeNode[1];
        helper(pRootOfTree, lastNode);
        TreeNode headNode = lastNode[0];
        while (headNode.left != null) headNode = headNode.left;
        return headNode;
    }

    public void helper(TreeNode root, TreeNode[] lastNode) {
        if (root == null) return;

        helper(root.left, lastNode);
        if (lastNode[0] != null) {
            lastNode[0].right = root;
        }
        root.left = lastNode[0];
        lastNode[0] = root;
        helper(root.right, lastNode);
    }
}
