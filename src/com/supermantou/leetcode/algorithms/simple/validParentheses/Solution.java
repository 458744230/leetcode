package com.supermantou.leetcode.algorithms.simple.validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if (stack.empty()){
                    return false;
                }
                Character c = stack.pop();
                switch (ch){
                    case ')':
                        if(c!='(') return false;
                        break;
                    case ']':
                        if(c!='[') return false;
                        break;
                    case '}':
                        if(c!='{') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
