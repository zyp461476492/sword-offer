package github.zyp.no4;

/**
 * <h1>面试题33：二叉搜索树的后序遍历序列</h1>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Problem33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length <= 0)
            return false;

        int root = sequence[end];

        int left = start;
        while (left <= end && sequence[left] < root) left++;

        int right = left;
        while (right <= end) {
            if (sequence[right] < root) return false;
            right++;
        }

        boolean leftFlag = true;
        if (left - start - 1 > 0) {
            leftFlag = helper(sequence, start, left - 1);
        }

        boolean rightFlag = true;
        if (right - left - 1 > 0) {
            rightFlag = helper(sequence, left, end - 1);
        }

        return leftFlag && rightFlag;
    }
}
