package github.zyp;

import github.zyp.no4.Problem4;
import github.zyp.no4.Problem5;
import org.junit.Test;

public class ProblemTest {

    /**
     * TODO java 数组初始化
     */
    @Test
    public void Problem4Test() {
        int[][] testCase = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        assert Problem4.Find(7, testCase);
    }

    @Test
    public void Problem5Test() {
        String testCase = "hello world";
        assert Problem5.replaceSpace(new StringBuffer(testCase)).equals("hello%20world");
    }

    @Test
    public void problem6Test() {

    }
}
