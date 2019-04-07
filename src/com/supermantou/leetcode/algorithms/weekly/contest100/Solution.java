package com.supermantou.leetcode.algorithms.weekly.contest100;

import java.util.*;

public class Solution {
    /*
    isMonotonic start
     */
    public boolean isMonotonic(int[] A) {
        boolean isup=true,isdown=true;
        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (isup && A[i] < prev){
                isup = false;
            }
            if (isdown && A[i] > prev){
                isdown = false;
            }
            if (!isup && !isdown){
                return false;
            }
            prev = A[i];
        }
        return isup || isdown;
    }
    /*
    isMonotonic end
    increasingBST start
     */
    private TreeNode answer = new TreeNode(-1);
    private TreeNode nowPos = answer;
    public TreeNode increasingBST(TreeNode root) {
        midlook(root);
        return answer.right;
    }
    public void midlook(TreeNode root){
        if (root == null){
            return;
        }
        midlook(root.left);
        nowPos.right = new TreeNode(root.val);
        nowPos = nowPos.right;
        midlook(root.right);
    }
    /*
    increasingBST end
     orderlyQueue start
     不能完全覆盖，按K=1和K>1分类讨论才对
     */
    public String orderlyQueue(String S, int K) {
        List<Character> characterList = new ArrayList<>();
        for (Character ch:S.toCharArray()){
            characterList.add(ch);
        }
        characterList.add(Character.MAX_VALUE);
//        if (S.length() == K){
//            Collections.sort(characterList);
//            StringBuilder sb = new StringBuilder();
//            for (Character ch:S.toCharArray()){
//                sb.append(ch);
//            }
//            return sb.toString();
//        }
        List<Character> kList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            kList.add(characterList.get(i));
        }
        int pos = K;
        for (; pos < characterList.size(); pos++) {
            kList.add(characterList.get(pos));
            boolean flag = false;
            for (int i = 0; i < K; i++) {
                if (kList.get(i).compareTo(kList.get(i+1)) > 0){
                    characterList.add(kList.get(i));
                    kList.remove(i);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                pos++;
                break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (Character ch:kList){
            if (ch == Character.MAX_VALUE){
                break;
            }
            answer.append(ch);
        }
        for (int i = pos; i < characterList.size(); i++) {
            if (characterList.get(i) == Character.MAX_VALUE){
                break;
            }
            answer.append(characterList.get(i));
        }
        return answer.toString();
    }
    /*
    orderlyQueue end
     start
     */

    public static void main(String[] args){
        Solution solution = new Solution();
//        System.out.print(solution.isMonotonic(new int[]{1,1,1}));
//        List<Integer> input = new ArrayList<>(Arrays.asList(5,3,6,2,4,null,8,1,null,null,null,7,9));
//        TreeNode root = new TreeNode(input.get(0));
//        List<TreeNode> queue = new ArrayList<>();
//        List<TreeNode> nextQueue = new ArrayList<>();
//        nextQueue.add(root);
//        for (int i = 1; i < input.size(); i++) {
//            queue.clear();
//            queue.addAll(nextQueue);
//            nextQueue.clear();
//            int len = queue.size() * 2;
//            for (int j = 0; j < len && i + j < input.size(); j++) {
//                TreeNode newnode = null;
//                if (input.get(i+j) != null){
//                    int pos = j / 2, remain = j % 2;
//                    newnode = new TreeNode(input.get(i+j));
//                    if (remain == 0){
//                        queue.get(pos).left = newnode;
//                    }else {
//                        queue.get(pos).right = newnode;
//                    }
//                }
//                nextQueue.add(newnode);
//            }
//        }
//        solution.increasingBST(root);
        System.out.print(solution.orderlyQueue("bca",1));
    }

}
