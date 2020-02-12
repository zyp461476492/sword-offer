package github.zyp.no4.chapter6;

/**
 * <h1>n个骰子的点数</h1>
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值的出现概率。
 * n 个骰子的点数和最大值为 6n，最小值为 n
 * 新加入一个骰子，它出现1-6的概率是相等的，可以看成各出现一次，
 * 那么出现和为s的次数等于再加入之前出现和为s-1,s-2,s-3,s-4,s-5,s-6这6种情况的次数之和。
 */
public class Problem60 {
    private static final int MAX = 6;

    public static void printProbability(int number) {
        if (number <= 0)
            return;
        // 出现和为 s 的次数等于再加入之前出现和
        // 为 s -1, s -2, ..., s - 6 这 6 种情况的和
        // 循环，直到 n 个骰子加入
        // 默认初始化为 0 个骰子和 1个骰子的情况
        int[][] result = new int[2][MAX * number + 1];
        // 初始化一个骰子的值
        for (int i = 1; i <= MAX; i++) {
            result[1][i] = 1;
        }
        // 从2个骰子开始，一直到 number 个骰子
        // 计算到 number 个骰子，每个和出现的次数
        for (int num = 2; num <= number; num++) {
            for (int i = num; i < MAX * number + 1; i++) {
                for (int j = i - MAX; j < i; j++) {
                    if (j > 0) {
                        result[num % 2][i] += result[(num - 1) % 2][j];
                    }
                }
            }
        }

        double sum = 0;
        // 计算所有和 S
        for (int i = number; i < MAX * number + 1; i++)
            sum += result[number % 2][i];
        System.out.println("number = " + number);
        // 计算每个和 S 出现的概率
        for (int i = number; i < MAX * number + 1; i++)
            System.out.println("probability " + i + ":" + result[number % 2][i] / sum);
    }
}
