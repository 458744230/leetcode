package com.supermantou.leetcode.algorithms.simple.palindromeNumber;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Solution {
    // 转化成字符串版本
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            if (x == 0) return true;
            return false;
        }
        String str = String.valueOf(x);
        String reversestr = new StringBuffer(str).reverse().toString();
        if (str.equals(reversestr)) {
            return true;
        }
        return false;
    }

    // 进阶:不用字符串版本
    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0) {
            if (x == 0) return true;
            return false;
        }
        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = 10 * reversedNumber + x % 10;
            x /= 10;
        }
        if (x == reversedNumber || x == reversedNumber/10){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome2(121));
    }
}
