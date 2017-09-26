package leetcode;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithOutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abba";
        LongestSubstringWithOutRepeatingCharacters temp = new LongestSubstringWithOutRepeatingCharacters();
        int res = temp.lengthOfLongestSubstring(str);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int res = 0;
        Map<Character, Integer> myMap = new HashMap<>();
        while (end < s.length()) {
            Character c = s.charAt(end);
            if (!myMap.containsKey(c)) {
                myMap.put(c, end);
            } else {
                res = Math.max(res, end - start);
                int duplicate = myMap.get(c);
                for (int i = start; i <= duplicate; i++) {
                    myMap.remove(s.charAt(i));
                }
                start = duplicate + 1;
                myMap.put(c, end);
            }
            end++;
        }
        res = Math.max(res, end - start);
        return res;
    }
}
