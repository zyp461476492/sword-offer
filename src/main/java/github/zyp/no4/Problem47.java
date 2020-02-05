package github.zyp.no4;

/**
 * <h1>面试题47：礼物的最大价值</h1>
 * <p>
 * 思路1：动态规划
 * f(i,j) = max(f(i-1, j), f(i, j - 1)) + gifts[i, j]
 * f(0,0) = gifts[0, 0]
 * f(0,1) = gifts[0,1] + f(0,0)
 * f(1,0) = gifts[1,0] + f(0,0)
 * f(1,1) = gifts[1,1] + max(f(0,1), f(1,0))
 * <p>
 * 申请一个与原矩阵行列数一样的二维数组dp[][]，初始化dp[0][i] = data[0][i]；
 * 然后依次更新dp的每一行即可。
 * 由于第m行的值与第m-1行和第m行有关，
 * 因此可以对dp进行简化，仅用两行的dp，即dp[2][]即可完成状态的记录与更新。
 */
public class Problem47 {

    public static int getMaxValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0 || gifts[0].length == 0)
            return 0;
        int[][] dp = new int[2][gifts[0].length];
        int dpCurRowIndex = 0, dpPreRowIndex = 0;
        for (int row = 0; row < gifts.length; row++) {
            // 判断奇偶
            dpCurRowIndex = row & 1;
            // 如果当前是偶数，则前一个就是奇数，类推
            dpPreRowIndex = 1 - dpCurRowIndex;
            for (int col = 0; col < gifts[0].length; col++) {
                if (col == 0)
                    dp[dpCurRowIndex][col] = dp[dpPreRowIndex][col] + gifts[row][col];
                else {
                    if (dp[dpPreRowIndex][col] >= dp[dpCurRowIndex][col - 1]) {
                        dp[dpCurRowIndex][col] = dp[dpPreRowIndex][col] + gifts[row][col];
                    } else {
                        dp[dpCurRowIndex][col] = dp[dpCurRowIndex][col - 1] + gifts[row][col];
                    }
                }
            }
        }
        return dp[(gifts.length - 1) & 1][gifts[0].length - 1];
    }
}
