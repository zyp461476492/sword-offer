package github.zyp.no4;

import java.util.HashMap;

/**
 * <h1>数组中出现次数超过一半的数字</h1>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 思路1：排序，然后找到出现次数符合要求的
 * 思路2：利用hash表，统计次数
 * 思路3：partition 算法，不占用额外的内存空间
 * 思路4：数组中一个数字出现的次数超过数组长度一半，也就是说它出现的次数比其他所有数字出现的次数
 * 的和还要多。
 */
public class Problem39 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int n : array) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }

        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > array.length / 2) result = key;
        }
        return result;
    }

    public int MoreThanHalfNum_SolutionQuickSort(int[] array) {
        if (array == null || array.length <= 0) return -1;
        int mid = array.length >>> 1;
        int start = 0, end = array.length - 1;
        int index = partition(array, 0, end);
        while (index != mid && index >= 0 && index < array.length) {
            if (index > mid) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index;
                index = partition(array, start, end);
            }
        }

        return array[index];
    }

    private int partition(int[] array, int lo, int hi) {
        int pivot = array[lo];
        while (lo < hi) {
            while (lo < hi && array[hi] >= pivot) hi--;
            array[lo] = array[hi];
            while (lo < hi && array[lo] <= pivot) lo++;
            array[hi] = array[lo];
        }
        // 跳出循环，此时 low = high 且就是轴点所在位置
        array[lo] = pivot;
        return lo;
    }
}
