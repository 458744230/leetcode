package com.supermantou.leetcode.algorithms.simple.removeDuplicatesFromSortedArray;

public class Solution {
    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = nums[0], count = 1;
        for (int i = 1, j = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                count++;
                pre = nums[i];
                nums[j++] = pre;
            }
        }
        return count;
    }
}
