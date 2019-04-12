package com.supermantou.leetcode.algorithms.weekly.contest;

import java.util.*;

public class Solution {
    private Integer val;
    public boolean isUnivalTree(TreeNode root) {
        val  = root.val;
        return go(root);
    }

    public boolean go(TreeNode node){
        if (node == null){
            return true;
        }
        if (node.val != val){
            return false;
        }
        return go(node.left) && go(node.right);
    }

    private List<Integer> answerList = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1){
            answerList.add(0);
        }
        for (int i = 1; i <= 9; i++) {
            go(i,1,N,K);
        }
        int[] answer = new int[answerList.size()];
        int i = 0;
        for (Integer a: answerList){
            answer[i] = a;
            i++;
        }
        return answer;

    }
    public void go(int prev,int deep,int N,int K){
        if (deep == N){
            answerList.add(prev);
            return;
        }
        int a = prev % 10;
        if (a >= K){
            go(prev*10+a-K,deep+1,N,K);
        }
        if (K > 0 && a + K < 10){
            go(prev*10+a+K,deep+1,N,K);
        }
    }
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] answer = solution.numsSameConsecDiff(2,0);
        Arrays.stream(answer).forEach(System.out::println);
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> lowmap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String str:wordlist){
            String s = str.toLowerCase();
            if (!lowmap.containsKey(s)){
                lowmap.put(s,str);
            }
           s = s.replace('e','a');
           s = s.replace('i','a');
           s = s.replace('o','a');
           s = s.replace('u','a');
           if (!map.containsKey(s)){
               map.put(s,str);
           }
           set.add(str);
        }
        String[] answer = new String[queries.length];
        int i = 0;
        for (String que:queries){
            if (set.contains(que)){
                answer[i] = que;
            }else {
                String s = que.toLowerCase();
                if (lowmap.containsKey(s)){
                    answer[i] = lowmap.get(s);
                }else {
                    s = s.replace('e','a');
                    s = s.replace('i','a');
                    s = s.replace('o','a');
                    s = s.replace('u','a');
                    answer[i] = map.getOrDefault(s,"");
                }
            }
            i++;
        }
        return answer;
    }
    private int count = 0;
    public int minCameraCover(TreeNode root) {
        go(root,false);
        return count;
    }
    public boolean go(TreeNode node,boolean parentIsCam){
        if (node == null){
            return false;
        }
        if (parentIsCam){
            int temp = count;
            boolean left = go(node.left,false);
            boolean right = go(node.right,false);
            if (left && right){
                count = temp+1;
                go(node.left,true);
                go(node.right,true);
                return true;
            }
            return false;
        }else {
            count++;
            go(node.left,true);
            go(node.right,true);
            return true;
        }
    }
}
