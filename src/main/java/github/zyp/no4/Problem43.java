package github.zyp.no4;

/**
 * <h1>1~n 整数中1出现的次数 </h1>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * 但是对于后面问题他就没辙了。
 */
public class Problem43 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += count(i);
        }
        return count;
    }

    private int count(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1)
                count++;
            n = n / 10;
        }
        return count;
    }
}
