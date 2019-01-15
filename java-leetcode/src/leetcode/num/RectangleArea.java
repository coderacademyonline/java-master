package leetcode.num;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *     在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/10 16:59
 */
public class RectangleArea {

    private int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C-A) * (D-B) + (G-E) * (H-F);
        if (C < E || D < F || G < A || H< D){
            // 无重合
            return total;
        }else {
            // 横坐标集合
            List<Integer> xList = new ArrayList<>(4);
            xList.add(A);
            xList.add(C);
            xList.add(E);
            xList.add(G);
            // 纵坐标集合
            List<Integer> yList = new ArrayList<>(4);
            yList.add(B);
            yList.add(D);
            yList.add(F);
            yList.add(H);

            Collections.sort(xList);
            Collections.sort(yList);

            // 重合面积
            int sArea = (xList.get(2)-xList.get(1)) * (yList.get(2) - yList.get(1));

            return total - sArea;
        }
    }
}
