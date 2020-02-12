package github.zyp.no4.chapter6;

import java.util.Arrays;

/**
 * <h1>面试题61：扑克牌中的顺子</h1>
 */
public class Problem61 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length <= 0) return false;
        Arrays.sort(numbers);
        // 统计 0 的个数，即大小王的个数
        int zeroCnt = 0;
        for (int n : numbers)
            if (n == 0)
                zeroCnt++;
        // 统计相邻数字空缺的个数
        int cnt = 0;
        for (int i = zeroCnt; i < numbers.length; i++) {
            if (i + 1 < numbers.length) {
                if (numbers[i + 1] > numbers[i])
                    cnt += numbers[i + 1] - numbers[i] - 1;
                else if (numbers[i + 1] == numbers[i]) {
                    return false;
                }
            }
        }

        return cnt == 0 || cnt == zeroCnt;
    }
}
