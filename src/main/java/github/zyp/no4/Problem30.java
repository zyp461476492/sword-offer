package github.zyp.no4;

import java.util.Stack;

/**
 * <h1>面试题30：包含min的栈</h1>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 * <p>
 * 思路：
 * 借助辅助栈，每次都把最小元素压入辅助栈，弹出时同步弹出，就能保证
 */
public class Problem30 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> helper = new Stack<Integer>();

    public void push(int node) {
        if (helper.isEmpty()) {
            helper.push(node);
        } else {
            // 同步放入最小值
            int min = helper.peek();
            helper.push(Math.min(node, min));
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helper.peek();
    }
}
