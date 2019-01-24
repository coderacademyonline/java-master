package leetcode.num;

/**
 * <p>
 *     报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。

 示例 1:

 输入: 1
 输出: "1"

 示例 2:
 输入: 4
 输出: "1211"

 输入：5
 输出："111221"

 输入：6
 输出："312211"
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/24 16:48
 */
public class BaoShu {

    public static void main(String[] args) {
        BaoShu baoShu = new BaoShu();
        System.out.println(baoShu.countAndSay(7));
    }

    public String countAndSay(int n) {
        String count = "1";
        for(int i=1;i<=n;i++){
            if (i==1){
                count = "1";
            }else if (i==2){
                count = "11";
            }else{
                count = strAndSay(count);
            }
        }
        return count;
    }

    public String strAndSay(String num){
        StringBuffer buffer = new StringBuffer("");
        char[] nums = num.toCharArray();
        int length = nums.length;
        String thisNum = String.valueOf(nums[0]);
        int count = 0;
        for(int i=0;i<length;i++){
            if (thisNum.equals(String.valueOf(nums[i]))){
                count++;
            }else{
                // 拼接buffer
                buffer.append(count+thisNum);
                // 修改thisNum的值
                thisNum=String.valueOf(nums[i]);
                // 修改count的值为1
                count=1;
            }
            if (i==length-1){
                // 拼接buffer
                buffer.append(count+thisNum);
            }
        }
        return buffer.toString();
    }
}
