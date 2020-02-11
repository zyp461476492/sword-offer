package github.zyp.no4;

import java.util.ArrayList;

/**
 * <h1>面试题57：和为S的数字</h1>
 * 题目1：和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：因为是排序的，二分查找
 * <p>
 * 题目2：和为S的连续正数序列
 * 输入一个正数S，打印出所有和为S的连续正数序列（至少含有两个树 ）
 * 思路和上一道题类似
 * 考虑用两个数 small 和 big 分别表示序列的最小值和最大值。
 * 首先把 small 初始化为1，big初始化为2
 * 如果从small到big的序列大于s,则去掉一个小的数字，直到small < (1+s)/2
 * 如果small到big的序列小于S，则要包括更多的数，即big++
 */
public class Problem57 {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;
        int small = 1, big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;
        ArrayList<Integer> sub = null;
        while (small < mid) {
            if (curSum == sum) {
                sub = addAll(small, big);
                if (!sub.isEmpty())
                    res.add(sub);
            }

            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    sub = addAll(small, big);
                    if (!sub.isEmpty())
                        res.add(sub);
                }
            }

            big++;
            curSum += big;
        }

        return res;
    }

    private static ArrayList<Integer> addAll(int small, int big) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = small; i <= big; i++)
            res.add(i);
        return res;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) return res;
        int left = 0, right = array.length - 1;
        int last = Integer.MAX_VALUE;
        while (left < right) {
            int curSum = array[left] + array[right];
            if (curSum > sum) {
                // 如果大了，要缩小数字，所以右边指针移动
                right--;
            } else if (curSum < sum) {
                // 小了，左边指针移动
                left++;
            } else {
                int curMulti = array[left] * array[right];
                if (curMulti < last) {
                    last = curMulti;
                    res.clear();
                    res.add(array[left]);
                    res.add(array[right]);
                }
                // 继续查找
                left++;
                right--;
            }
        }
        return res;
    }
}
