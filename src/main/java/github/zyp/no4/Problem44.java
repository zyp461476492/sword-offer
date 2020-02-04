package github.zyp.no4;

/**
 * <h1>面试题44：数字序列中某一位的数字</h1>
 */
public class Problem44 {

    int digitIndex(int index) {
        if (index < 0) return 1;

        // 当前数字的位数
        int digits = 1;

        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitIndex(index, digits);
            }
            index -= digits * index;
        }
    }

    /**
     * <h2>计算当前位数的数字对应的数字个数有多少</h2>
     * 例如 2 位数，总共就是 10 个数字（1，2，3，4，5，6，7，8，9，0）
     * 例如 3 位数，总共就是
     *
     * @param digits 位数
     * @return 对应数字个数
     */
    private int countOfIntegers(int digits) {
        if (digits == 1)
            return 10;
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    private int digitIndex(int index, int digits) {
        int number = beginNumber(digits);
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        return number % 10;
    }

    /**
     * 获取当前位数的其实数字
     */
    private int beginNumber(int digits) {
        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
