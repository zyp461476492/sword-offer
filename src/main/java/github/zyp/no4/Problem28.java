package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题28：对称二叉树</h1>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * <p>
 * 思路：
 * 镜像二叉树是前序遍历 根左右
 * 这里我们自定义一个前序遍历，根右左
 * 如果这两个相同，则说明是对称
 */
public class Problem28 {

    boolean isSymmetrical(TreeNode pRoot) {
        return helper(pRoot, pRoot);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
