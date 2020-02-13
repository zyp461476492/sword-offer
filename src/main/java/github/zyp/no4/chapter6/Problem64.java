package github.zyp.no4.chapter6;

/**
 * <h1>面试题64：求1+2+3+...+n</h1>
 * 要求不能用乘除法，for,while，if,else，switch，case 等关键字
 */
public class Problem64 {

    public static void main(String[] args) {
        System.out.println(count(10));
    }

    private static int count(int n) {
        int t = 0;
        boolean b = (n > 0) && ((t = n + count(n - 1)) > 0);
        return t;
    }


}
