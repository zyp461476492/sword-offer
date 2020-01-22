package github.zyp.no4;

/**
 * <h1>面试题5：替换空格</h1>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Problem5 {
    public static String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        // 计算空格数量
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') count++;
        }
        int newLen = oldLen + count * 2;
        int p = oldLen - 1, q = newLen - 1;
        str.setLength(newLen);
        while (p >= 0 && q > p) {
            char c = str.charAt(p);
            if (c != ' ') {
                str.setCharAt(q--, c);
            } else {
                // 空格
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            }
            p--;
        }
        return str.toString();
    }
}
