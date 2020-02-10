package github.zyp.no4;

/**
 * <h1>面试题53：在排序数组中查找数字</h1>
 * 题目1：数字在排序数组中出现的次数
 */
public class Problem53 {
    public static void main(String[] args) {
        Problem53 p53 = new Problem53();
//        int[] array = {1,2,3,3,3,3,4,5};
//        System.out.println(p53.getFirst1(array, 3));
    }

    /**
     * <h2>题目1答案</h2>
     * 因为是二分查找，所以时间复杂度是 log(n)
     */
    int getFirst1(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int start = 0;
        int end = array.length - 1;
        int first = 0;
        int last = 0;
        // 找到第一次出现的 target
        while (start <= end) {
            int mid = (end + start) / 2;
            if (array[mid] < target) {
                // 去后半段进行查找
                start = mid + 1;
            } else if (array[mid] > target) {
                // 去前半段进行查找
                end = mid - 1;
            } else {
                if (mid - 1 >= 0 && array[mid - 1] == target) {
                    end = mid - 1;
                } else {
                    first = mid;
                    System.out.println("first");
                    break;
                }
            }
        }

        // 找到最后一次出现的 target 位置
        start = 0;
        end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (array[mid] < target) {
                // 去后半段进行查找
                start = mid + 1;
            } else if (array[mid] > target) {
                // 去前半段进行查找
                end = mid - 1;
            } else {
                if (mid + 1 < array.length - 1 && array[mid + 1] == target) {
                    start = mid + 1;
                } else {
                    last = mid;
                    System.out.println("last");
                    break;
                }
            }
        }

        return last - first + 1;
    }

    /**
     * <h2>题目2：0~n-1中缺失的数字</h2>
     * length = n - 1
     * 解法1：利用通项公式 n(n-1)/2 求出 n - 1 个数字之和，然后计算差即可
     * 解法2：利用排序的特性，问题变成了利用二分查找寻找第一个下标不正确的元素即可
     */
    private int getMissingNumber(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == mid) {
                left = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] == mid - 1)
                    return mid;
                right = mid - 1;
            }
        }
        return -1;
    }
}
