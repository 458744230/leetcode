package com.supermantou.nowcoder.huawei;
import java.util.*;

public class Tes {
    private static Set<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "*", "/", "(", ")"));
    /* 功能：四则运算

     * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"

     * 返回：算术表达式的计算结果

     */

    public static int calculate(String strExpression)
    {
        strExpression = strExpression.replace("{","(");
        strExpression = strExpression.replace("}",")");
        strExpression = strExpression.replace("[","(");
        strExpression = strExpression.replace("]",")");
        List<String> numbers = new ArrayList<>();
        Stack<Character> operator = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        char last = '(';
        for (char c : strExpression.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
                flag = true;
            } else {
                if (flag) {
                    numbers.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                flag = false;
                if (c == ')'){
                    for (int i = 0; i < operator.size(); i++) {
                        Character ch = operator.pop();
                        if (ch == '(') {
                            break;
                        } else {
                            numbers.add(ch.toString());
                        }
                    }
                }else if (c == '+' || c == '-'){
                    if (c == '-' && last == '('){
                        numbers.add("0");
                    }
                    while (!operator.empty() && operator.peek() != '(') {
                        numbers.add(operator.pop().toString());
                    }
                    operator.push(c);
                }else{
                    operator.push(c);
                }
            }
            last = c;
        }
        if (flag) {
            numbers.add(sb.toString());
        }

        while (operator.size() > 0) {
            String c = operator.pop().toString();
            if (!"(".equals(c) && !")".equals(c))
                numbers.add(c);
        }
        /* 请实现*/

        return eval2(numbers);

    }

    public static Integer eval2(List<String> numbers) {
        int num_ = numbers.size();
        if (num_ == 1) {
            return Integer.valueOf(numbers.get(0));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num_; i++) {
            String input = numbers.get(i);
            if (operatorSet.contains(input)) {
                int a = stack.pop(), b = stack.pop(), c = 0;
                if ("+".equals(input)){
                    c = b + a;
                }else if ("-".equals(input)){
                    c = b - a;
                }else if ("*".equals(input)){
                    c = b * a;
                }else{
                    c = b / a;
                }
                stack.push(c);
            } else {
                stack.push(Integer.valueOf(input));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
//        System.out.println(calculate("3+2*{1+2*[-4/(8-6)+7]}"));
        System.out.println(calculate("{3+2*3}*{1+2*[-4/(8-6)+7]}"));
    }
}
