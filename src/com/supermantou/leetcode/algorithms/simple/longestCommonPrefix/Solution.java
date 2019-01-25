package com.supermantou.leetcode.algorithms.simple.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if (size == 0) return "";
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            Character ch = strs[0].charAt(i);
            for (int j = 1; j < size; j++) {
                if(strs[j].length()-1 < i || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
