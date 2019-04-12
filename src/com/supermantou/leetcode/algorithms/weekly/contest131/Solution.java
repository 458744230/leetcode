package com.supermantou.leetcode.algorithms.weekly.contest131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        int flag = 0;
        List<Integer> ends = new ArrayList<>();
        ends.add(0);
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                flag++;
            } else {
                flag--;
                if (flag == 0) {
                    ends.add(i + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ends.size() - 1; i++) {
            sb.append(S.substring(ends.get(i) + 1, ends.get(i + 1) - 1));
        }
        return sb.toString();
    }

    public int sumRootToLeaf(TreeNode root) {
        List<TreeNode> leafList = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> nextQueue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.get(0);
            int baseVal = (node.val * 2) % (1000000007);
            if (node.left != null){
                node.left.val = (baseVal + node.left.val) ;
                nextQueue.add(node.left);
            }
            if (node.right != null){
                node.right.val = (baseVal + node.right.val);
                nextQueue.add(node.right);
            }else if (node.left == null){
                leafList.add(node);
            }
            queue.remove(0);
            if (queue.isEmpty() && !nextQueue.isEmpty()){
                queue.addAll(nextQueue);
                nextQueue.clear();
            }
        }
        int sum = 0;
        for (TreeNode node:leafList){
            sum += node.val;
            sum %= 1000000007;
        }
        return sum;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        int len = pattern.length();
        char[] pat = pattern.toCharArray();
        for (String que:queries){
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (char c:que.toCharArray()){
                if (i < len && c == pat[i]){
                    i++;
                }else {
                    sb.append(c);
                }
            }
            boolean flag = true;
            if (i < len){
                flag = false;
            }else {
                for (char c:sb.toString().toCharArray()){
                    if(c >= 'A' && c <= 'Z'){
                        flag = false;
                        break;
                    }
                }
            }
            answer.add(flag);
        }
        return answer;
    }

    class Clip{
        int start,end;
        public int getLen(){
            return end-start;
        }

        public Clip(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int total = 0;
    public int videoStitching(int[][] clips, int T) {
        List<Clip> clipList = new ArrayList<>();
        for (int[] clip:clips){
            if (clip[1] > T){
                if (clip[0] >= T){
                    continue;
                }else {
                    clip[1] = T;
                }
            }
            clipList.add(new Clip(clip[0],clip[1]));
        }
        if (divide(clipList,0,T)){
            return total;
        }else {
            return -1;
        }
    }
    public Boolean divide(List<Clip> clipList,int b,int e){
        if (clipList.size() == 0){
            return false;
        }
        clipList.sort((c1,c2)->c2.getLen()-c1.getLen());
        Clip bound = clipList.get(0);
        int left=bound.start,right=bound.end;
        total++;
        if (left <= b && right >= e){
            return true;
        }
        if (left > b ){
            List<Clip> leftClips = new ArrayList<>();
            for (Clip c:clipList){
                if (c.start >= left){
                    continue;
                }else if (c.end > left){
                    c.end = left;
                }
                leftClips.add(c);
            }
            if (!divide(leftClips,b,left)){
                return false;
            }
        }
        if (right < e){
            List<Clip> rightClips = new ArrayList<>();
            for (Clip c:clipList){
                if (c.end <= right){
                    continue;
                }else if (c.start < right){
                    c.start = right;
                }
                rightClips.add(c);
            }
            if (!divide(rightClips,right,e)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
//        System.out.print(solution.removeOuterParentheses("()()"));
        int[][] clips = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.print(solution.videoStitching(clips,9));
    }
}
