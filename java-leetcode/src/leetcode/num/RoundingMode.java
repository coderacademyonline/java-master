package leetcode.num;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/12/14 16:58
 */
public enum RoundingMode {
    /**
     * 向上取整，但是，如果是坐标轴的话，这个都是远离零的方向取整，5.5->6; -2.5->-3
     */
    UP(BigDecimal.ROUND_UP),
    /**
     * 向下取整，但是，如果是坐标轴的话，这个都是靠近零的方向取整，5.5->5; -2.5->-2
     */
    DOWN(BigDecimal.ROUND_DOWN),
    /**
     * 向正无限大方向舍入的舍入模式。此舍入模式始终不会减少计算值。向上取整
     */
    CEILING(BigDecimal.ROUND_CEILING),
    FLOOR(BigDecimal.ROUND_FLOOR),
    HALF_UP(BigDecimal.ROUND_HALF_UP),
    HALF_DOWN(BigDecimal.ROUND_HALF_DOWN),
    HALF_EVEN(BigDecimal.ROUND_HALF_EVEN),
    UNNECESSARY(BigDecimal.ROUND_UNNECESSARY);

    final int oldMode;

    private RoundingMode(int oldMode) {
        this.oldMode = oldMode;
    }

    public static RoundingMode valueOf(int rm) {
        switch(rm) {

            case BigDecimal.ROUND_UP:
                return UP;

            case BigDecimal.ROUND_DOWN:
                return DOWN;

            case BigDecimal.ROUND_CEILING:
                return CEILING;

            case BigDecimal.ROUND_FLOOR:
                return FLOOR;

            case BigDecimal.ROUND_HALF_UP:
                return HALF_UP;

            case BigDecimal.ROUND_HALF_DOWN:
                return HALF_DOWN;

            case BigDecimal.ROUND_HALF_EVEN:
                return HALF_EVEN;

            case BigDecimal.ROUND_UNNECESSARY:
                return UNNECESSARY;

            default:
                throw new IllegalArgumentException("argument out of range");
        }
    }
}
