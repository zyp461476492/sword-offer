package github.zyp.no4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h1>面试题40：最小的 k 个数 </h1>
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 思路1：排序，然后依次输出 K 个数
 * 思路2：大根堆或小根堆
 */
public class Problem40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (input == null || k == 0) return res;
        if (input.length < k) return res;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int n : input) {
            if (maxQueue.size() < k) {
                maxQueue.add(n);
            } else {
                // 堆顶元素大于当前元素，则弹出堆顶元素，加入当前元素到堆中
                if (maxQueue.peek() > n) {
                    maxQueue.poll();
                    maxQueue.add(n);
                }
            }
        }

        res.addAll(maxQueue);
        return res;
    }
}
