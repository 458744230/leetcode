package com.supermantou.leetcode.algorithms.roman2Integer;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);

        int len = s.length();
//        int flag[] = new int[len];
        int max = valueMap.get(s.charAt(len-1));
        int value = 0;
        for (int i = len -1; i >= 0; i--) {
            int v = valueMap.get(s.charAt(i));
            if(v >= max){
                value += valueMap.get(s.charAt(i));
                if (v > max){
                    max = v;
                }
            }else {
                value -= v;
            }
        }
        return value;
    }

    public static void main(String[] args){
        System.out.println(new Solution().romanToInt("IIIV"));
    }
}
