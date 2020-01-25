package github.zyp.no4;


import java.util.Arrays;

/**
 * <h1>面试题17：打印1到最大的N的树 </h1>
 */
public class Problem17 {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;

        char[] arr = new char[n + 1];
        Arrays.fill(arr, '0');

        for (int i = 0; i < 10; ++i) {
            arr[0] = (char) (i + 48);
            helper(arr, n, 0);
        }
    }

    private void helper(char[] arr, int length, int index) {
        if (index == length - 1) {
            printNum(arr);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            // '0' 48
            arr[index + 1] = (char) (i + 48);
            helper(arr, length, index + 1);
        }
    }

    private void printNum(char[] arr) {
        boolean zeroFlag = true;
        int len = arr.length;

        for (char c : arr) {
            if (zeroFlag && c != '0') {
                zeroFlag = false;
            }

            if (!zeroFlag)
                System.out.print(c);
        }
        System.out.println();
    }
}
