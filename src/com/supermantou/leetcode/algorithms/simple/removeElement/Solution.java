package com.supermantou.leetcode.algorithms.simple.removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                pos++;
            }else {
                if (pos > 0){
                    nums[i-pos] = nums[i];
                }
            }
        }
        return len-pos;
    }
}
