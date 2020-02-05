package github.zyp.no4;

/**
 * <h1>面试题49：丑数</h1>
 * <p>
 * 思路1：
 * 逐个判断质数
 * 思路2：
 * 找到一种计算丑数的方法，丑数应该是一个丑数*2，*3，*5的结果，
 * 所以，我们可以创建一个数组，里面的数字是排好序的丑数，
 * 每个丑数都是前面的丑数乘以2或3或5得成的
 */
public class Problem49 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        // [0, index - 1] 总共 index 个
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int nextIndex = 1;
        int ugly2 = 0;
        int ugly3 = 0;
        int ugly5 = 0;
        while (nextIndex < index) {
            int min = min(uglyArray[ugly2] * 2,
                    uglyArray[ugly3] * 3, uglyArray[ugly5] * 5);
            uglyArray[nextIndex] = min;

            while (uglyArray[ugly2] * 2 <= uglyArray[nextIndex])
                ugly2++;
            while (uglyArray[ugly3] * 3 <= uglyArray[nextIndex])
                ugly3++;
            while (uglyArray[ugly5] * 5 <= uglyArray[nextIndex])
                ugly5++;

            nextIndex++;
        }

        return uglyArray[index - 1];
    }

    private int min(int x, int y, int z) {
        if (x < y) return Math.min(x, z);
        else return Math.min(y, z);
    }

    public int GetUglyNumber_SolutionV1(int index) {
        if (index <= 0) return 0;

        int number = 0;
        int count = 0;
        while (count <= index) {
            number++;
            if (isUglyV2(number)) {
                count++;
            }
        }
        return number;
    }

    private boolean isUglyV1(int num) {
        if (num < 1) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        return num == 1;
    }

    private boolean isUglyV2(int number) {
        while (number % 2 == 0)
            number = number / 2;
        while (number % 3 == 0)
            number = number / 3;
        while (number % 5 == 0)
            number = number / 5;
        return number == 1;
    }
}
