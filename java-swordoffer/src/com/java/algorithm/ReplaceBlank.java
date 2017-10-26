package com.java.algorithm;

/**
 * Created by zhaojw
 * Date: 2017/10/26
 * Time: 14:21
 * 请实现一个函数，把字符串中的每个空格替换成“%20” ==  类似于Java的replaceAll
 * @author: zhaojw
 */
public class ReplaceBlank {

    public static void replaceBlank(String target){
        if (target==null){
            return;
        }
        StringBuffer sb=new StringBuffer();
        char[] chars=target.toCharArray();
        for (char c : chars) {
            //也可以直接使用c==' '，不必担心空指针的问题
            if (" ".equals(String.valueOf(c))){
                sb.append("%");
                sb.append("2");
                sb.append("0");
            }else{
                sb.append(String.valueOf(c));
            }
        }
        System.err.println(sb.toString());
    }

    public static void main(String[] args){
        replaceBlank("we are  happy");
    }
}
