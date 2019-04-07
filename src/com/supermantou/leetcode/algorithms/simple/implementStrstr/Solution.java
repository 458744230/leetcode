package com.supermantou.leetcode.algorithms.simple.implementStrstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (len == 0) return 0;
        int pi[] = new int[needle.length()];
        pi[0] = 0;
        int k = 0;
        for (int i = 1; i < len; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i)){
                k = pi[k-1];
            }
            if (needle.charAt(k) == needle.charAt(i)){
                k++;
            }
            pi[i] = k;
        }
        int q = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while ( q > 0 && haystack.charAt(i) != needle.charAt(q)){
                q = pi[q-1];
            }
            if (haystack.charAt(i) == needle.charAt(q)){
                q++;
            }
            if (q == len){
                return i-q+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        System.out.println(new Solution().strStr("abbaaaaa","bba"));
        System.out.println(new Solution().strStr("hello","ll"));
        System.out.println(new Solution().strStr("bacbababaca","ababaca"));
    }
}
