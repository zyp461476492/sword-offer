package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题7：重建二叉树</h1>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 例如:
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 中序遍历序列{4,7,2,1,5,3,8,6}
 * <p>
 * 思路：
 * 前序遍历的第一个值是根节点
 * 中序遍历找到根节点，根节点左边的是左子树，右边的是右子树
 * 前序遍历后的X个元素是左子树，Y个元素是右子树
 * X是中序遍历根节点左边节点数量
 * Y是中序遍历根节点右边节点数量
 */
public class Problem7 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return core(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode core(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = core(pre, startPre + 1, startPre + (i - startIn),
                        in, startIn, i - 1);
                root.right = core(pre, (i - startIn) + startPre + 1, endPre,
                        in, i + 1, endIn);
            }
        }
        return root;
    }
}
