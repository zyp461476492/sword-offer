package github.zyp.no4;

/**
 * <h1>面试题46：把数字翻译成字符串</h1>
 */
public class Problem46 {

    int getTranslationCount(int number) {
        if (number < 0) return 0;

        return core(number + "");
    }

    private int core(String number) {
        return 0;
    }
}
