package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

import java.util.Stack;

/**
 * <h1>面试题54：二叉搜索树的第 k 大的节点</h1>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 思路：
 * 中序遍历是排序的数组
 * 第 K 个节点就是 第 length - k 个节点
 * 先计算长度，随后找到第 length - k 个节点
 */
public class Problem54 {

    TreeNode KthNode(TreeNode root, int k) {
        //栈顶元素保证一直是cur的父节点
        if (root == null || k < 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count++;
                if (count == k)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }

}
