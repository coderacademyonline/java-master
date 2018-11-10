package leetcode.str;

/**
 * <p>
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/9 12:07
 */
public class StrStr {

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "a", needle = "a";
        System.out.println("indexOf():"+strStr.strStr(haystack,needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle == null || "".equals(needle)) {
            return 0;
        }

        if (haystack == null || "".equals(haystack)) {
            return -1;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        int length = haystackLength - needleLength;
        char[] chars = haystack.toCharArray();
        for (int i = 0; i <= length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int j=i;j<(needleLength+i);j++){
                stringBuffer.append(chars[j]);
            }
            if (needle.equals(stringBuffer.toString())){
                return i;
            }

        }
        return -1;
    }
}
