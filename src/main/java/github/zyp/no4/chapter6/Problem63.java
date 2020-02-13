package github.zyp.no4.chapter6;

/**
 * <h1>股票的最大利润</h1>
 */
public class Problem63 {

    /**
     * 数组 dp[i] 表示第 i 个卖出时的最大利润
     * dp[i] = number[i] - min(dp[0, i - 1])
     *
     * @param number
     * @return
     */
    private static int maxDiff(int[] number) {
        if (number == null || number.length == 0) return 0;
        int min = number[0];
        int[] diff = new int[number.length];
        for (int i = 1; i < number.length; i++) {
            if (number[i - 1] < min)
                min = number[i - 1];
            diff[i] = number[i] - min;
        }

        int max = Integer.MIN_VALUE;
        for (int n : diff) {
            if (n > max)
                max = n;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
