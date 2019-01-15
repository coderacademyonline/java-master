package leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/12/5 23:02
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateOneByOne("",result,n,n);
        return result;
    }

    private void generateOneByOne(String sublist, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0) {
            generateOneByOne(sublist + "(", result, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(sublist + ")", result, left, right - 1);
        }
    }
}
