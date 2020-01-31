package github.zyp.no4;

import java.util.ArrayList;

/**
 * <h1>面试题38：字符串的全排列</h1>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * <p>
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Problem38 {

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.isEmpty()) return res;
        helper(0, str.toCharArray());
        return res;
    }

    private void helper(int pos, char[] chars) {
        if (pos == chars.length - 1) {
            if (!res.contains(new String(chars))) {
                res.add(new String(chars));
            }
        }
        for (int i = pos; i < chars.length; i++) {
            //首部字符和它后面的字符（包括自己）进行交换
            char temp = chars[i];
            chars[i] = chars[pos];
            chars[pos] = temp;
            //递归求后面的字符的排列
            helper(pos + 1, chars);
            //由于前面交换了一下，所以chs的内容改变了，我们要还原回来
            temp = chars[i];
            chars[i] = chars[pos];
            chars[pos] = temp;

        }
    }
}
