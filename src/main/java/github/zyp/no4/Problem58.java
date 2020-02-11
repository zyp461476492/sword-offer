package github.zyp.no4;

/**
 * <h1>面试题58：翻转字符串</h1>
 * 题目1：翻转单词顺序
 * 翻转句子中单词的顺序
 * <p>
 * 思路：两次翻转
 * 第一次翻转整个句子的顺序
 * 第二次翻转每一个单词的顺序
 * <p>
 * 题目2：左旋转字符串
 * 思路：计算移动后的下标
 */
public class Problem58 {
    private static void reverse(char[] arr, int s, int e) {
        if (arr == null || s >= e || s >= arr.length || e >= arr.length) return;
        while (s < e) {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0 || n >= str.length())
            return str;
        // 第一步，对整体翻转
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        // 第二步，翻转[0, len - n - 1]
        reverse(arr, 0, arr.length - n - 1);
        // 第三步，翻转[len - n, len - 1]
        reverse(arr, arr.length - n, arr.length - 1);
        return new String(arr);
    }

    public String ReverseSentence(String str) {
        char[] strArr = str.toCharArray();
        // 第一遍翻转
        reverse(strArr, 0, strArr.length - 1);
        int p = 0, q = p + 1;
        while (q < strArr.length) {
            while (q < strArr.length && strArr[q] != ' ') q++;
            // 翻转单词
            reverse(strArr, p, q - 1);
            p = q + 1;
            q = p + 1;
        }
        return new String(strArr);
    }
}
