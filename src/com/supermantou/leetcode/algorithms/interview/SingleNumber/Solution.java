package com.supermantou.leetcode.algorithms.interview.SingleNumber;

public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3,2,4,5,6,4,3,6};
//        int[] nums = {4,1,2,1,2};
        Solution solution = new Solution();
        System.out.print(solution.singleNumber(nums));
    }
}
