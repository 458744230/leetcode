package com.supermantou.leetcode.algorithms.middle.zigzagConversion;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int size = s.length();
        int cycle = 2*(numRows-1);
        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < size; j+=cycle) {
            try {
                stringBuffer.append(s.charAt(j));
            }catch (Exception e){
                // do nothing
            }
        }
        for (int i = 1; i < numRows-1 && i < size; i++) {
            stringBuffer.append(s.charAt(i));
            for (int j = cycle; j < size+cycle; j+=cycle) {
                try {
                    stringBuffer.append(s.charAt(j - i));
                    stringBuffer.append(s.charAt(j + i));
                }catch (Exception e){
                    // do nothing
                }
            }
        }
        for (int j = numRows-1;j < size; j+=cycle) {
            try {
                stringBuffer.append(s.charAt(j));
            }catch (Exception e){
                // do nothing
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String args[]){
        System.out.println(new Solution().convert("LEETCODEISHIRING",4));
    }
}
