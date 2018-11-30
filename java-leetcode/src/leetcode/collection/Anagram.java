package leetcode.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 *     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/22 18:02
 */
public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String s = "a";
        String t = "ab";
        System.out.println(anagram.isAnagram(s,t)?"是异位词":"不是异位词");
    }

    public boolean isAnagram(String s, String t) {

        if (s == null||s=="" || t==null || t==""){
            return false;
        }
        Map<String,Integer> sMap = this.strToMap(s);
        Map<String,Integer> tMap = this.strToMap(t);

        return this.isEqualsMap(sMap,tMap);
    }

    private Map<String,Integer> strToMap(String source){
        char[] sources = source.toCharArray();
        Map<String,Integer> map = new HashMap<>(16);
        for(char c:sources){
            String key = String.valueOf(c);
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return map;
    }

    private boolean isEqualsMap(Map<String,Integer> sMap,Map<String,Integer> tMap){
        if (sMap.size() != tMap.size()){
            return false;
        }
        Set<Map.Entry<String,Integer>> sEntry = sMap.entrySet();
        for (Map.Entry<String,Integer> entry:sEntry){
            String key = entry.getKey();
            if (!tMap.containsKey(key)){
                return false;
            }
            if (!Objects.equals(entry.getValue(),tMap.get(key))){
                return false;
            }
        }
        return true;
    }
}
