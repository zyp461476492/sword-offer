package github.zyp.no4.chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>面试题62：圆圈中剩下的数字</h1>
 * 约瑟夫环的问题
 */
public class Problem62 {

    public static void main(String[] args) {
        System.out.println("ans: " + lastRemaining(5, 3));
    }

    /**
     * <h2>数学公式算法</h2>
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * <h2>用循环链表模拟的算法</h2>
     */
    public static int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n - 1; i++)
            list.add(i);
        Iterator<Integer> iterator = list.iterator();

        int cnt = 0;
        while (list.size() != 1) {
            cnt++;
            if (!iterator.hasNext()) {
                iterator = list.iterator();
            }
            int i = iterator.next();
            if (cnt == m) {
                cnt = 0;
                iterator.remove();
                if (!iterator.hasNext()) {
                    iterator = list.iterator();
                }
                cnt++;
                System.out.println("remove: " + i + " next: " + iterator.next());
            }
        }
        return list.get(0);
    }
}
