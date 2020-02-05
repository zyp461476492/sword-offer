package github.zyp.no4;

/**
 * <h1>面试题46：把数字翻译成字符串</h1>
 * 自上而下，从最大的问题开始，递归 ：
 * 12258
 * /       \
 * b+2258       m+258
 * /   \         /   \
 * bc+258 bw+58  mc+58  mz+8
 * /  \      \        \     \
 * bcc+58 bcz+8   bwf+8   mcf+8  mzi
 * /        \       \     \
 * bccf+8        bczi    bwfi   mcfi
 * /
 * bccfi
 * 有很多子问题被多次计算，比如258被翻译成几种这个子问题就被计算了两次。
 * <p>
 * 自下而上，动态规划，从最小的问题开始 ：
 * f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。
 * 递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
 * 其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
 * 因此，对于12258：
 * f(5) = 0
 * f(4) = 1
 * f(3) = f(4)+0 = 1
 * f(2) = f(3)+f(4) = 2
 * f(1) = f(2)+f(3) = 3
 * f(0) = f(1)+f(2) = 5
 * 这里的 g(r-2, r-1) 就是 r-2 和 r-1 是否能够翻译成字符串（也就是 10<=g<=25）
 * 这里讲 r 变成 r + 2，所以递归公式变成
 * f(r) = f(r+1)+g(r,r+1)*f(r+2)；
 */
public class Problem46 {

    public static void main(String[] args) {
        Problem46 p46 = new Problem46();
        System.out.println(p46.getTranslationCount(12258));
    }
    int getTranslationCount(int number) {
        if (number < 0) return 0;
        return core(number + "");
    }

    private int core(String number) {
        int count = 0;
        int[] counts = new int[number.length() + 1];
        char[] arr = number.toCharArray();
        counts[arr.length] = 0;
        counts[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            count = counts[i + 1];
            int digit1 = arr[i] - '0';
            int digit2 = arr[i + 1] - '0';
            int digit = digit1 * 10 + digit2;
            // 判断 g(r, r+1)
            if (digit >= 10 && digit <= 25) {
                count += counts[i + 2];
            }
            counts[i] = count;
        }
        return counts[0];
    }
}
