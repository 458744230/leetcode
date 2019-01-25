package com.supermantou.leetcode.algorithms.middle.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 1,i = 0,j=0;
        for (; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
               j = Math.max(map.get(s.charAt(i)),j);
            }
            max = max>i-j+1?max:i-j+1;
            map.put(s.charAt(i),i+1);

        }
        return max;
    }

    public static void main(String []args){
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
