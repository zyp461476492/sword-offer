package github.zyp.no4;

/**
 * <h1>面试题48：最长不含重复字符的子字符串</h1>
 */
public class Problem48 {

    public static void main(String[] args) {
        Problem48 p48 = new Problem48();
        System.out.println(p48.longestSubString("arabcacfr"));
    }

    int longestSubString(String str) {
        if (null == str || str.isEmpty()) return 0;
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int maxDp = 0;
        for (int dpIndex = 1; dpIndex < dp.length; dpIndex++) {
            int i = dpIndex - 1;
            for (; i >= dpIndex - dp[dpIndex - 1]; i--) {
                // 看 dp[i] 的长度范围内是否存在重复字符
                if (str.charAt(i) == str.charAt(dpIndex))
                    break;
            }
            dp[dpIndex] = dpIndex - i;
            if (dp[dpIndex] > maxDp)
                maxDp = dp[dpIndex];
        }
        return maxDp;
    }
}
