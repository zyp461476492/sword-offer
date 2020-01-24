package github.zyp.no4;

import java.util.Arrays;

/**
 * <h1>面试题13：机器人活动范围</h1>
 */
public class Problem13 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;
        boolean[] visited = new boolean[rows * cols];
        Arrays.fill(visited, false);

        return core(threshold, rows, cols, 0, 0, visited);
    }

    private int core(int threshold, int rows, int cols,
                     int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count += core(threshold, rows, cols, row + 1, col, visited) +
                    core(threshold, rows, cols, row - 1, col, visited) +
                    core(threshold, rows, cols, row, col + 1, visited) +
                    core(threshold, rows, cols, row, col - 1, visited) + 1;
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols,
                          int row, int col, boolean[] visited) {
        int sum = getSum(row) + getSum(col);
        return sum <= threshold && row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row * cols + col];
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
