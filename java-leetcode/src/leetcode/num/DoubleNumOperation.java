package leetcode.num;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * <p>
 *    精度数值操作，包括加、减、乘、除 ，以及科学计数法
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/12/14 11:45
 */
public class DoubleNumOperation {

    public static void main(String[] args) {
        DoubleNumOperation operation = new DoubleNumOperation();
        Double a = 6.28d;
        Double b = 3.1415d;
        System.out.println("相加："+operation.plus(a,b));
        System.out.println("相减："+operation.subtract(a,b));
        System.out.println("相乘："+operation.multiply(0.00001d,10d));
        operation.showFormat(operation.divide(a,b));
    }

    private Double plus(Double a,Double b){
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b);
        return bigDecimal1.add(bigDecimal2).doubleValue();
    }

    private Double subtract(Double a,Double b){
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b);
        return bigDecimal1.subtract(bigDecimal2).doubleValue();
    }

    private String multiply(Double a,Double b){
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(a));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(b));

        BigDecimal result = bigDecimal1.multiply(bigDecimal2);
        DecimalFormat format = new DecimalFormat("#.######");
        format.setRoundingMode(RoundingMode.DOWN);
        return format.format(result);
    }

    private Double divide(Double a,Double b){
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b);
        return bigDecimal1.divide(bigDecimal2,6,BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 测试各种舍入模式的不同
     *
     * @param result 待格式化的参数
     */
    private void showFormatMore(Double result) {
        System.out.println("初始值：" + result.toString());
        DecimalFormat decimalFormat = new DecimalFormat("0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println("HALF_EVEN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("HALF_UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        System.out.println("HALF_DOWN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("FLOOR：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        System.out.println("CEILING：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.UP);
        System.out.println("UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("DOWN：" + decimalFormat.format(result));
    }

    /**
     * 打印数据遭格式化之后的效果(默认是HALF_EVEN，他不是四舍五入，)
     *
     * @param value 待格式化的参数
     */
    private void showFormat(Double value) {
        System.out.println("初始值：" + value.toString());
        System.out.println("取一位整数："+new DecimalFormat("0").format(value));
        System.out.println("取一位整数和两位小数："+new DecimalFormat("0.00").format(value));
        System.out.println("取两位整数和三位小数，整数不足部分以0填补："+new DecimalFormat("00.000").format(value));
        System.out.println("取所有整数部分："+new DecimalFormat("#").format(value));
        System.out.println("以百分比方式计数，并取两位小数："+new DecimalFormat("#.##%").format(value));
        System.out.println("显示为科学计数法，并取五位小数："+new DecimalFormat("#.#####E0").format(value));
        System.out.println("显示为两位整数的科学计数法，并取四位小数："+new DecimalFormat("00.####E0").format(value));
        System.out.println("每三位以逗号进行分隔："+new DecimalFormat(",###").format(value));
        System.out.println("将格式嵌入文本："+new DecimalFormat("所传入的格式化参数是：###大小。").format(value));
    }
}
