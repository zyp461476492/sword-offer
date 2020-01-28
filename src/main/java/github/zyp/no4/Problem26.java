package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题26：树的子结构</h1>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Problem26 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = helper(root1, root2);
            }

            if (!result)
                result = HasSubtree(root1.left, root2);
            if (!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null) return false;

        if (p.val != q.val)
            return false;
        return helper(p.left, q.left) && helper(p.right, q.right);
    }
}
