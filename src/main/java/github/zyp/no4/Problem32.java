package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>面试题32：从上到下打印二叉树</h1>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 思路：
 * 层次遍历，借助队列
 */
public class Problem32 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        return result;
    }
}
