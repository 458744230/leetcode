package com.supermantou.leetcode.algorithms.interview.MajorityElement;

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0,temp = 0;
        for (int num : nums){
            if (count == 0){
                temp = num;
                count = 1;
            }else if (num == temp){
                count++;
            }else {
                count--;
            }
        }
        return temp;
    }
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args){
        int[] input = new int[]{3,2,3,2,2,1,1};
        Solution solution = new Solution();
        System.out.print(solution.majorityElement(input));
    }
}
