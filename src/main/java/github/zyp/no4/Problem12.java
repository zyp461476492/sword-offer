package github.zyp.no4;

/**
 * <h1>面试题12：矩阵中的路径</h1>
 */
public class Problem12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        if (str.length == 0) {
            return true;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (helper(matrix, rows, cols, str, row, col, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[] matrix,
                          int rows, int cols,
                          char[] str, int row,
                          int col, int pathLength, boolean[] visited) {
        if (row < 0 || row >= rows
                || col < 0 || col >= cols
                || str[pathLength] != matrix[row * cols + col]
                || visited[row * cols + col]) {
            return false;
        }
        if (pathLength == str.length - 1) {
            return true;
        }

        boolean hasPath = false;
        visited[row * cols + col] = true;

        hasPath = helper(matrix, rows, cols, str, row, col + 1, pathLength + 1, visited)
                || helper(matrix, rows, cols, str, row, col - 1, pathLength + 1, visited)
                || helper(matrix, rows, cols, str, row + 1, col, pathLength + 1, visited)
                || helper(matrix, rows, cols, str, row - 1, col, pathLength + 1, visited);

        if (hasPath) return true;
        visited[row * cols + col] = false;
        return false;
    }

}
