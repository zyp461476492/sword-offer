package github.zyp.no4;

/**
 * <h1>面试题10：费伯纳西数列</h1>
 * <p>
 * 思路：
 * fn =
 * n = 0 fn = 0
 * n = 1 fn = 1
 * n > 1 fn = fn-1 + fn - 2
 */
public class Problem10 {
    public static int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
