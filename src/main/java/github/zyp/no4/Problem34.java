package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

import java.util.ArrayList;

/**
 * <h1>面试题34：二叉树中和为某一值的路径</h1>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 注意: 在返回值的list中，数组长度大的数组靠前
 */
public class Problem34 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(root, target, 0, path);
        return result;
    }

    public void helper(TreeNode root, int target, int currentSum, ArrayList<Integer> path) {
        if (root != null) {
            currentSum += root.val;
            path.add(root.val);

            // 如果是叶子节点，且找到了值
            if (root.left == null && root.right == null && currentSum == target) {
                ArrayList<Integer> temp = new ArrayList<Integer>(path);
                result.add(temp);
            }

            if (root.left != null) {
                helper(root.left, target, currentSum, path);
            }
            if (root.right != null) {
                helper(root.right, target, currentSum, path);
            }
            path.remove(path.size() - 1);
        }
    }
}
