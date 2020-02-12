package github.zyp.no4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>面试题59：队列的最大值</h1>
 * 题目1：滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 题目2：队列的最大值
 * 请定义一个队列实现函数 max 得到队列里的最大值，要求 max ，push_back，pop_front 的时间复杂度都是 o(1)
 */
public class Problem59 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            Deque<Integer> deque = new LinkedList<>();
            // 先放入第一个窗口的数据
            for (int i = 0; i < size; i++) {
                while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                    // 当后一个元素大于队列内元素时，说明这个元素不可能是最大值，尾端弹出
                    deque.pollLast();
                }
                deque.addLast(i);
            }

            // 继续放入剩下的数据
            for (int i = size; i < num.length; i++) {
                res.add(num[deque.peekFirst()]);
                // 当前的元素已经从滑动窗口中滑出
                while (!deque.isEmpty() && i - deque.getFirst() + 1 > size)
                    deque.pollFirst();
                while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                    deque.pollLast();
                if (!deque.isEmpty() && i - deque.getFirst() >= size) {
                    deque.pollFirst();
                }
                deque.addLast(i);
            }
            res.add(num[deque.peekFirst()]);
        }
        return res;
    }

    /**
     * 应该保存 index来解决相同元素的问题
     */
    class MaxQueue {
        Deque<Integer> dataQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        public void pushBack(int n) {
            dataQueue.addLast(n);
            if (maxQueue.isEmpty()) maxQueue.addLast(n);
            else {
                while (!maxQueue.isEmpty() && n > maxQueue.peekLast())
                    maxQueue.pollLast();
                maxQueue.addLast(n);
            }
        }

        public int popFront() {
            int elem = dataQueue.peekFirst();
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == elem) {
                maxQueue.pollFirst();
            }
            dataQueue.pollFirst();
            return elem;
        }

        public int max() {
            return maxQueue.peekFirst();
        }
    }
}
