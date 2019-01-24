package com.supermantou.leetcode.algorithms.integerReverse;

public class Solution {
    public int reverse(int x) {
//        if(x == -2147483648){
//            return 0;
//        }
        int sign = x > 0? 1: -1;
        x = x * sign;
        String str = String.valueOf(x);
        str = new StringBuffer(str).reverse().toString();
//        if(str.length() == 10 && str.compareTo("2147483647") > 0){
//            return 0;
//        }
        try {
            x = Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }

        return sign * x;
    }
    public static void main(String[] args){
        int ret = new Solution().reverse(-2147483648);
        System.out.println(ret);
    }
}
