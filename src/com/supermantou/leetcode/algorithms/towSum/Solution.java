package com.supermantou.leetcode.algorithms.towSum;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = {0,0};
        HashMap<Integer,Integer> hashMap = new HashMap<>(); // MAP内的类型必须是对象
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                res[0] = hashMap.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            hashMap.put(nums[i],i);
        }
        return res;

    }
}
