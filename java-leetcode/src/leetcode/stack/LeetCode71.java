package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *     以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
       在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分
       请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

         输入："/a/./b/../../c/"
         输出："/c"

         输入："/a/../../b/../c//.//"
         输出："/c"
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/19 09:48
 */
public class LeetCode71 {

    public static void main(String[] args) {
        LeetCode71 leetCode71 = new LeetCode71();
        String path = "/a//b////c/d//././/..";
        System.out.println(leetCode71.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        if (path == null || "".equals(path)){
            return "";
        }
        Stack<String> stack = new Stack<>();
        // 以/ 拆分字符串
        String[] paths = path.split("/");

        // paths = ["a",".","b","..","..","c"]
        for (int i=0;i<paths.length;i++){
            String p = paths[i];
            if ("".equals(p) || ".".equals(p)){
                continue;
            }
            if ("..".equals(p)){
                if (!stack.empty()){
                    stack.pop();
                }
            }else{
                stack.push(p);
            }
        }
        List<String> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        StringBuffer buffer = new StringBuffer("/");
        for (int i=list.size()-1;i>=0;i--){
            buffer.append(list.get(i));
            if (i>0){
                buffer.append("/");
            }
        }
        return buffer.toString();
    }
}
