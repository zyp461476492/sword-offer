package github.zyp.no4;

import java.util.Stack;

/**
 * <h1>面试题9：用两个栈实现队列</h1>
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 思路：
 * 当 stack2 不为空时，在 stack2 中的栈顶元素就是最先进入队列的元素，可以弹出。
 * 如果 stack2 为空，则将 stack1 中元素依次弹出并入 stack2，弹出 stack2 栈顶元素即可。
 * push,全部 push进 stack1 中
 */
public class Problem9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
