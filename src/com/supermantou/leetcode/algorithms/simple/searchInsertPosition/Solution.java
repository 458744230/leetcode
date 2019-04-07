package com.supermantou.leetcode.algorithms.simple.searchInsertPosition;

public class Solution {
    // 顺序搜索
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }

        return i;
    }

    // 二分搜索
    public int searchInsert2(int[] nums, int target) {
        int right = nums.length, left = 0;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
