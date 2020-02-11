package github.zyp.no4;

/**
 * <h1>面试题56：数组中数字出现的次数</h1>
 * 题目1：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 要求时间复杂度o(n),空间复杂度 o(1)
 * 思路：任何一个数字异或它自己都等于它本身
 * 因为结果 a,b不想等，所以结果的二进制表示中至少有一位1，
 * 找到那个1的位置p，然后我们就可以根据第p位是否为1将所有的数字分成两堆，
 * 这样我们就把所有数字分成两部分，且每部分都是只包含一个只出现一次的数字、
 * 其他数字出现两次，从而将问题转化为最开始我们讨论的“数组中只出现一次的一个数字”问题。
 */
public class Problem56 {

    public static int findFirstBit1(int num) {
        if (num < 0)
            return -1;
        int indexOf1 = 1;
        while (num != 0) {
            if ((num & 1) == 1)
                return indexOf1;
            else {
                num = num >> 1;
                indexOf1 *= 2;
            }
        }
        return -1;
    }

    public void FindNumsAppearOnce(int[] data, int num1[], int num2[]) {
        int result = 0;
        for (int value : data) result ^= value;
        int indexOf1 = findFirstBit1(result);
        if (indexOf1 < 0)
            return;
        for (int datum : data) {
            if ((datum & indexOf1) == 0)
                num1[0] ^= datum;
            else
                num2[1] ^= datum;
        }
    }
}
