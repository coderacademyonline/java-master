package leetcode.array;


import java.math.BigDecimal;

/**
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/24 23:25
 */
public class NumberReverse {

    public static void  main(String[] args){
        NumberReverse numberReverse = new NumberReverse();

        System.err.println(numberReverse.numberReverse(-2147483648));
    }


    private int sizeOfInt(int x) {
        int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
                99999999, 999999999, Integer.MAX_VALUE };
        for (int i = 0;; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

    private int numberReverse(int number){
       String numStr = String.valueOf(number);
        String prefix = "";
        if (numStr.startsWith("-")){
            prefix = "-";
            numStr = numStr.substring(1,numStr.length());
        }
        char[] numbers = numStr.toCharArray();
        int length = numbers.length;
        StringBuffer numberStr = new StringBuffer();
        int zeroNum = 0;
        for(int i=length-1;i>=0;i--){
            int thisChar = Integer.valueOf(String.valueOf(numbers[i]));
            zeroNum  += thisChar;
            if (zeroNum != 0){
                numberStr.append(thisChar);
            }
        }

        System.out.println("numberStr:"+numberStr);
        if ("".equals(numberStr.toString())){
            return 0;
        }
        if (new BigDecimal(numberStr.toString()).compareTo(new BigDecimal(Integer.MAX_VALUE))>0){
            return 0;
        }
        if (!"".equals(prefix)){
            return new BigDecimal(numberStr.toString()).multiply(new BigDecimal(-1)).intValue();
        }

        return new BigDecimal(numberStr.toString()).intValue();
    }
}
