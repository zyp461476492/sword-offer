package github.zyp.no4;

/**
 * <h1>面试题21：调整数组顺序使奇数位于偶数前面</h1>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分,
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 爆破法：
 * 从头扫描，遇到一个偶数，拿出这个偶数，把后面所有元素前移，偶数放到最后
 */
public class Problem21 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;

        // 奇数
        int[] odd = new int[array.length];
        // 偶数
        int[] even = new int[array.length];

        int oddCount = 0;
        int evenCount = 0;

        for (int n : array) {
            if (n % 2 == 0) {
                // even
                even[evenCount++] = n;
            } else {
                odd[oddCount++] = n;
            }
        }

        if (oddCount >= 0) System.arraycopy(odd, 0, array, 0, oddCount);

        if (evenCount >= 0) System.arraycopy(even, 0, array, oddCount, evenCount);

    }

    public void reOrderArray1(int[] array) {
        if (array == null || array.length == 0) return;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            // 移动 left ，直到指向偶数
            while (left < right && (array[left] % 2 != 0)) {
                left++;
            }

            // 移动 right 直到指向奇数
            while (left < right && (array[right] % 2 == 0))
                right--;

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }
}
