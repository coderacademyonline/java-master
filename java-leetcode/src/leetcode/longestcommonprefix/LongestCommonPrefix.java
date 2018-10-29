package leetcode.longestcommonprefix;

/**
 * <p>
 *     编写一个函数来查找字符串数组中的最长公共前缀。
 *     例如：
 *     输入: ["flower","flow","flight"]
 *      输出: "fl"
 *      输入: ["dog","dogracecar","dogcar"]
 *      输出: ""
 *      解释: 输入不存在公共前缀。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/29 00:03
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        LongestCommonPrefix main = new LongestCommonPrefix();
        //String[] strs = {"dog","dogracecar","dogcar"};
        String[] strs = {"a","ab","c"};
        //String[] strs = {"flower","flow","flight"};
        System.err.println("最大公共前缀："+main.longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <=0){
            return "";
        }
       Integer endIndex = recursive(strs,1);
       return strs[0].substring(0,endIndex);
    }

    public Integer recursive(String[] strs,Integer endIndex){
        boolean isFirst = true;
        String prefix = "";
        for (String str:strs){
            if ("".equals(str) || str == null){
                return 0;
            }
            if (endIndex > str.length()){
                return endIndex-1;
            }
            if (isFirst){
                prefix = str.substring(0,endIndex);
                isFirst = false;
            }
            if (!str.startsWith(prefix)){
                return endIndex-1;
            }
        }

        return recursive(strs,endIndex+1);
    }
}
