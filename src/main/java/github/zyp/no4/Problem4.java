package github.zyp.no4;

/**
 * <h1>面试题4：二维数组中的查找</h1>
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路：
 * 选择右上角的数字
 * 如果等于，返回结果
 * 如果该数字大于目标数字，剔除这个数字所在的列
 * 如果该数字小于目标数字，剔除这个数字所在的行
 */
public class Problem4 {
    public static boolean Find(int target, int[][] array) {

        int rows = array.length;
        if (rows <= 0) return false;
        int cols = array[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            int cur = array[row][col];

            if (cur == target) return true;
            else if (cur > target) {
                // 当前数大于目标数，剔除当前列
                col--;
            } else {
                // 当前数小于目标数，剔除当前行
                row++;
            }
        }

        return false;
    }
}
