package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题27：二叉树的镜像</h1>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 思路：
 * 遍历树的过程中交换左右节点
 * 先序遍历，遍历中交换左右节点即可。
 */
public class Problem27 {

    public void Mirror(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            helper(root.left);
            helper(root.right);
        }
    }
}
