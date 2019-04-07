package com.supermantou.leetcode.algorithms.interview.String;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /*
    isPalindrome start
     */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^(a-zA-Z0-9)]", "").toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        int pos = s.length() - 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= pos; i++, pos--) {
            if (chars[i] != chars[pos]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int begin = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (begin < s.length() - 1 && !isInCharSet(chars[begin])) {
            begin++;
        }
        while (end > 0 && !isInCharSet(chars[end])) {
            end--;
        }
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
            while (begin < s.length() - 1 && !isInCharSet(chars[begin])) {
                begin++;
            }
            while (end > 0 && !isInCharSet(chars[end])) {
                end--;
            }
        }
        return true;
    }

    public boolean isInCharSet(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    /*
    isPalindrome end
    partition start
     */
    public boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        int len = s.length();
        isPalindrome = new boolean[len][len];
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = chars[i] == chars[i + 1];
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                isPalindrome[j][i + j] = (chars[j] == chars[i + j] && isPalindrome[j + 1][i + j - 1]);
            }
        }
        List<List<String>> answer = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(chars, answer, path, 0, len);
        return answer;
    }

    public void dfs(char[] chars, List<List<String>> answer, List<Integer> path, int deep, int len) {
        if (deep >= len) {
            if (isPalindrome[path.get(path.size() - 1)][len - 1]) {
                path.add(len);
                List<String> plan = new ArrayList<>();
                StringBuilder sb;
                for (int i = 0; i < path.size() - 1; i++) {
                    sb = new StringBuilder();
                    sb.append(chars, path.get(i), path.get(i + 1) - path.get(i));
                    plan.add(sb.toString());
                }
                answer.add(plan);
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(deep);
        for (int i = deep; i < len; i++) {
            if (isPalindrome[deep][i]) {
                dfs(chars, answer, path, i + 1, len);
            }
        }
        path.remove(path.size() - 1);
    }

    /*
    partition end
    wordBreak start
   */
//    class node{
//        char character;
//        HashMap<Character,node> next;
//        boolean hasend = false;
//
//        public node(char character) {
//            this.character = character;
//            next = new HashMap<>();
//        }
//    }
//    public boolean wordBreak(String s, List<String> wordDict) {
//        HashMap<Character,node> wordMap = new HashMap<>();
//        wordDict.sort(Comparator.comparingInt(String::length));
//        boolean flag = false;
//        for (String str:wordDict){
//            char[] chars = str.toCharArray();
//            if (flag && dfs(chars,0,wordMap)){
//                continue;
//            }
//            HashMap<Character,node> nowMap = wordMap;
//            for (int i = 0; i < chars.length; i++) {
//                char c = chars[i];
//                if (!nowMap.containsKey(c)){
//                    nowMap.put(c,new node(c));
//                }
//                if (i == chars.length -1){
//                    nowMap.get(c).hasend = true;
//                }else {
//                    nowMap = nowMap.get(c).next;
//                }
//            }
//            flag = true;
//        }
//        return dfs(s.toCharArray(),0,wordMap);
//    }
//    // 最坏情况遍历解空间超时，甚至不如暴力解，不应该用dfs
//    public boolean dfs(char[] chars,int start,HashMap<Character,node> wordMap){
//        if (start >= chars.length){
//            return false;
//        }
//        HashMap<Character,node> nowMap = wordMap;
//        List<Integer> anotherWay = new ArrayList<>();
//        for (int i = start; i < chars.length; i++) {
//            if (nowMap.containsKey(chars[i])){
//                if (nowMap.get(chars[i]).hasend){
//                    if (i == chars.length -1){
//                        return true;
//                    }else {
//                        if (wordMap.containsKey(chars[i+1])){
//                            anotherWay.add(i+1);
//                        }
//                    }
//                }
//                nowMap = nowMap.get(chars[i]).next;
//            }else {
//                break;
//            }
//        }
//        for (int i = anotherWay.size()-1; i >= 0; i--) {
//            if (dfs(chars,anotherWay.get(i),wordMap)){
//                return true;
//            }
//        }
//        return false;
//    }
    /*
    wordBreak end
    wordBreak2 start
   */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(), max_len = 0;
        for (String str : wordDict) {
            max_len = str.length() > max_len ? str.length() : max_len;
        }
        boolean[] v = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        v[0] = true;
        for (int i = 1; i <= n; i++) {
            int j = max_len >= i ? 0 : i - max_len;
            for (; j < i; j++) {
                if (v[j] && wordSet.contains(s.substring(j, i))) {
                    v[i] = true;
                    break;
                }
            }
        }
        return v[n];
    }

    /*
    wordBreak2 end
   */
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.print(solution.isPalindrome2(".,"));
//        List<List<String>>  answer = solution.partition("cbbbcc");
//        for(List<String> stringList:answer){
//            System.out.print("[");
//            for (String str:stringList){
//                System.out.print(str);
//                System.out.print(",");
//            }
//            System.out.print("]\n");
//        }
//        List<String> wordDict = new ArrayList<>(Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"));
//        System.out.print(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",wordDict));
        List<String> wordDict = new ArrayList<>(Arrays.asList("ba", "baa", "ab"));
        System.out.print(solution.wordBreak("baab", wordDict));
    }
}
