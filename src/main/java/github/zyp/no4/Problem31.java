package github.zyp.no4;

import java.util.Stack;

/**
 * <h1>面试题31：栈的压入，弹出序列</h1>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 */
public class Problem31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        boolean bPossible = false;
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int value : pushA) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop(); //出栈
                ++popIndex;
            }
        }
        bPossible = stack.isEmpty() && popA.length - 1 == popIndex;
        return bPossible;
    }
}
