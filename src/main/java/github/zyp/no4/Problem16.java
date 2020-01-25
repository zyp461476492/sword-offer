package github.zyp.no4;

/**
 * <h1>面试题1：</h1>
 * 通项公式
 * a的n次等于
 * a的 n / 2 次方 * a的 n / 2 次方 n 为偶数
 * a 的 (n - 1 ) / 2 * a 的 (n - 1 ) / 2 n 为奇数
 */
public class Problem16 {

    public double Power(double base, int exponent) {
        if (new Double(0.0).equals(base)) {
            return 0;
        }

        boolean flag = exponent > 0;
        double result = helper(base, Math.abs(exponent));
        if (!flag) {
            result = 1.0 / result;
        }
        return result;
    }

    private double helper(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        // 右移操作代替除法
        double result = helper(base, exponent >>> 1);

        //  用位操作代替 %
        result *= result;
        if ((exponent & 0x1) == 1) {
            // 是奇数
            result *= base;
        }
        return result;
    }
}
