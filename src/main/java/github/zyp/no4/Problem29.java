package github.zyp.no4;

import java.util.ArrayList;

/**
 * <h1>面试题29：顺时针打印矩阵</h1>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Problem29 {
    ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows < 1) return result;
        int cols = matrix[0].length;
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            helper(matrix, rows, cols, start);
            start++;
        }
        return result;
    }

    public void helper(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }

        // 从上到下打印
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endY]);
            }
        }

        // 从右到左打印
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
}
