package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题55：二叉树的深度</h1>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class Problem55 {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return core(root, 1);
    }

    public int core(TreeNode root, int length) {
        if (root != null) {
            int left = length, right = length;
            if (root.left != null)
                left = core(root.left, length + 1);
            if (root.right != null)
                right = core(root.right, length + 1);
            return Math.max(left, right);
        }
        return length;
    }
}
