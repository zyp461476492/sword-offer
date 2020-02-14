package github.zyp.no4.chapter6;

/**
 * <h1>面试题65：不用加减乘除做加法</h1>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Problem65 {
    /**
     * 二进制加法：用异或操作：相同为0，不同为1
     * 进位标志计算：与操作，然后左移
     */
    public int Add(int num1, int num2) {
        int sum = 0, carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

}
