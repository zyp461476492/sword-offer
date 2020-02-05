package github.zyp.no4;

/**
 * <h1>面试题51：数组中的逆序对</h1>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 可通过如下步骤求逆序对个数：先把数组逐步分隔成长度为1的子数组，
 * 统计出子数组内部的逆序对个数，
 * 然后再将相邻两个子数组合并成一个有序数组并统计数组之间的逆序对数目，
 * 直至合并成一个大的数组。其实，这是二路归并的步骤，
 * 只不过在归并的同事要多进行一步统计。
 * 因此时间复杂度o(nlogn)，空间复杂度o(n)，如
 * 果使用原地归并排序，可以将空间复杂度降为o(1)。
 */
public class Problem51 {

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2)
            return 0;
        return mergeSortCore(array, 0, array.length - 1);
    }

    public int mergeSortCore(int[] array, int start, int end) {
        if (start >= end)
            return 0;
        int mid = start + (end - start) / 2;
        int left = mergeSortCore(array, start, mid);
        int right = mergeSortCore(array, mid + 1, end);
        int count = merge(array, start, end, mid);
        return left + right + count;
    }

    public int merge(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        for (int i = 0; i <= end - start; i++)
            temp[i] = arr[i + start];
        int left = mid, right = mid + 1 - start;
        int index = start;
        int count = 0;
        while (left <= mid - start && right <= end - start) {
            // 左半部分和有半部分未越界
            if (temp[left] <= temp[right]) {
                arr[index++] = temp[left++];
            } else {
                // 逆序现象
                arr[index++] = temp[right++];
                // 左半部分的长度 - 左半部分下标
                count += (mid - start) - left + 1;
            }
        }

        // 剩余数据处理
        while (left <= mid - start)
            arr[index++] = temp[left++];
        while (right <= end - start)
            arr[index++] = temp[right++];
        return count;
    }
}
