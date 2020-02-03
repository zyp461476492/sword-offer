package github.zyp.no4;

/**
 * <h1>连续子数组的最大和</h1>
 * 给一个数组，返回它的最大连续子序列的和
 * <p>
 * 思路1：
 * 找到所有的子数组的排列，并计算，时间复杂度 o(N2)
 * 思路2：
 * 动态规划
 * f(i)=
 * 1.array[i] i = 0 或者 f(i-1) <= 0
 * 2.array[i] + f(i-1) i != 0 且 f(i-1) > 0
 */
public class Problem42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            curSum += array[i];
            // 当累计和比自身还小时，说明当前元素的大小大于前面的子数组和
            // 所以重新开始计算
            if (curSum < array[i]) {
                curSum = array[i];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public int FindGreatestSumOfSubArrayWithDp(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            dp[i] = array[i];
            if (dp[i - 1] > 0) dp[i] = dp[i - 1] + array[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
