package github.zyp.no4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h1>面试题41：数据流中的中位数</h1>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * <p>
 * 思路：
 * 数组容器被分割为两个部分，位于容器左边的数据总是比容器右边的数据小
 * p1 是左边容器的最大值，p2 是左边容器最小的
 * p1 和 p2 就是中位数
 * 插入时，所有数目是偶数时把新数据插入最小堆，否则插入最大堆
 */
public class Problem41 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        int count = minHeap.size() + maxHeap.size();
        if (count % 2 == 0) {
            // 要保证最小堆的元素都大于最大堆的元素
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            // 要保证最大堆中的元素都小于最小堆的元素
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public Double GetMedian() {
        int count = minHeap.size() + maxHeap.size();
        if (count == 0) return 0.0;

        Double mid = 0.0;
        if (count % 2 == 0) {
            mid = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            mid = Double.valueOf(minHeap.peek());
        }
        return mid;
    }
}
