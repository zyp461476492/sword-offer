package github.zyp.no4;

import github.zyp.no4.common.TreeNode;

/**
 * <h1>面试题37：序列化二叉树</h1>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 */
public class Problem37 {

    int index = 0;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return root.val + "!" +
                Serialize(root.left) +
                Serialize(root.right);
    }

    TreeNode Deserialize(String str) {

        if (index >= str.length()) return null;
        TreeNode root = null;
        // 读取数字
        String digitStr = readDigit(str);
        if (!digitStr.isEmpty()) {
            root = new TreeNode(Integer.parseInt(digitStr));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }

    private String readDigit(String str) {
        StringBuilder digitStr = new StringBuilder();
        while (index < str.length()
                && str.charAt(index) != '!' && str.charAt(index) != '#') {
            digitStr.append(str.charAt(index));
            index++;
        }
        // 跳到下一个待读取的位置
        index++;
        return digitStr.toString();
    }
}
