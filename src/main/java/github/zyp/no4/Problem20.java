package github.zyp.no4;

/**
 * <h1>面试题20：表示数值的字符串</h1>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 思路：
 * 1.尽可能的多扫描数字
 * 2.扫描完数字后，判断是否存在小数位，进行扫描
 * 3.扫描完小数位后，判断是否存在指数位，进行扫描
 */
public class Problem20 {
    int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;

        // 扫描数字
        boolean numeric = scanInteger(str);
        // 扫描小数位
        if (index < str.length && str[index] == '.') {
            index++;
            // 扫描小数位, 小数位后可以为 0
            // 小数位不能是负数
            numeric = scanUnsignedInteger(str) || numeric;
        }
        // 扫描指数位
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // 指数必须存在
            numeric = scanInteger(str) && numeric;
        }

        return numeric && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length
                && (str[index] == '+' || str[index] == '-')) {
            // 跳过符号位
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && Character.isDigit(str[index])) {
            index++;
        }
        // 判断是否是数字
        return index > start;
    }
}
