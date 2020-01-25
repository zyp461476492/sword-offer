package github.zyp.no4;

/**
 * <h1>面试题19：正则表达式</h1>
 * 存在问题
 * 这个 ignore *
 * core(str, pattern, s, p + 2);
 */
public class Problem19 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;

        return core(str, pattern, 0, 0);
    }

    public boolean core(char[] str, char[] pattern, int s, int p) {
        // 匹配成功
        if (s == str.length && p == pattern.length) return true;

        if (s != str.length && p == pattern.length) return false;

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            if (s < str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                // 可以移动到下一个状态
                // p + 2 是跳过当前相同的字符和*字符
                return core(str, pattern, s + 1, p + 2) ||
                        // 或者停留当前状态
                        core(str, pattern, s + 1, p) ||
                        core(str, pattern, s, p + 2);
            } else {
                return core(str, pattern, s, p + 2);
            }
        }

        if (s < str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
            return core(str, pattern, s + 1, p + 1);
        }

        return false;
    }
}
