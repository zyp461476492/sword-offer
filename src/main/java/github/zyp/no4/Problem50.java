package github.zyp.no4;

import java.util.HashMap;

/**
 * <h1>面试题50：第一个只出现一次的字符</h1>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Problem50 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null) return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            indexMap.put(c, i);
        }

        int min = Integer.MAX_VALUE;
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count == 1) {
                int index = indexMap.get(key);
                if (index < min) min = index;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
