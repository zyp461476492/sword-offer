package github.zyp.no4.chapter6;

/**
 * <h1>面试题66：构建乘积数组</h1>
 */
public class Problem66 {

    /**
     * C[i]=C[i-1]*A[i-1]
     * D[i] =D[i+1]*A[i+1]
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 0) return null;
        int[] result = new int[A.length];
        result[0] = 1;
        // 计算 C ，放入 result 数组
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }
        // 先计算 D 数组元素，再与 C 数组元素向乘法
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            // 数组中 D 的值
            temp = temp * A[i + 1];
            result[i] = temp * result[i];
        }
        return result;
    }
}
