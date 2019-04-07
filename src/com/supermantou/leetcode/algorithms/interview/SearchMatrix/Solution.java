package com.supermantou.leetcode.algorithms.interview.SearchMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length && matrix[i][0] <= target; i++) {
            if(matrix[i][0] == target) return true;
            if(matrix[i][matrix[i].length-1] > target){
                continue;
            }else if (matrix[i][matrix[i].length-1] == target){
                return true;
            }
            for (int j = 1; j < matrix[i].length && matrix[i][j] <= target; j++) {
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] input = new int[][]{};
        Solution solution = new Solution();
        System.out.print(solution.searchMatrix(input,1));
    }
}
