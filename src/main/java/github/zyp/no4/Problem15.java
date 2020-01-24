package github.zyp.no4;

/**
 * <h1>面试题15：二进制中1的个数</h1>
 */
public class Problem15 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n > 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
