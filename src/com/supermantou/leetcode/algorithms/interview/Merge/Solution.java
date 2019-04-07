package com.supermantou.leetcode.algorithms.interview.Merge;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp1 = new int[m+1];
        int[] temp2 = new int[n+1];
        for (int i = 0; i < m; i++) {
            temp1[i] = nums1[i];
        }
        temp1[m] = Integer.MAX_VALUE; // 哨兵
        for (int i = 0; i < n; i++) {
            temp2[i] = nums2[i];
        }
        temp2[n] = Integer.MAX_VALUE; // 哨兵
        for (int i = 0,j = 0, k = 0; i < m + n; i++) {
            if(temp1[j] > temp2[k]){
                nums1[i] = temp2[k];
                k++;
            }else {
                nums1[i] = temp1[j];
                j++;
            }
        }

    }
}
