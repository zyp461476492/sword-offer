package github.zyp.no4;

/**
 * <h1>面试题11：旋转数组的最小数字</h1>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Problem11 {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int p = 0;
        int q = array.length - 1;
        int mid = p;

        while (array[p] <= array[q]) {
            if (q - p == 1) {
                mid = q;
                break;
            }

            mid = (p + q) / 2;
            if (array[p] == array[q] && array[q] == array[mid]) {
                // 三个下标指向数字相同，只能进行顺序查找
                return helper(array, p, q);
            }

            if (array[mid] >= array[p]) {
                p = mid;
            } else if (array[mid] <= array[q]) {
                q = mid;
            }
        }
        return array[mid];
    }

    public static int helper(int[] array, int p, int q) {
        int result = array[p];
        for (int i = p + 1; i <= q; i++) {
            if (array[i] < result)
                result = array[i];
        }
        return result;
    }
}
