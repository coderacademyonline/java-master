package leetcode.ispalindrome;

/**
 * <p>
 *   判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/25 15:06
 */
public class IsPalindrome {

    public static void main(String[] args){
        IsPalindrome isPalindrome = new IsPalindrome();
        System.err.println(isPalindrome.isPalindrome(-121));
    }

    public boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        int partEnd = length%2 == 0 ? length/2 : (length-1)/2;
        for(int i=0;i<=partEnd;i++){
            if (chars[i] != chars[length-1-i]){
                return false;
            }
        }
        return true;
    }
}
