package com.supermantou.nowcoder.huawei;

import java.util.*;

public class Eval {

//    public void addNum(Stack<String> stack,int num){
//        if (!stack.empty()){
//            int cur = 0;
//            if ("*".equals(stack.peek()) || "/".equals(stack.peek())){
//                String top = stack.pop();
//                cur = Integer.parseInt(stack.pop());
//                num = "*".equals(top)?(cur*num):(cur/num);
//            }
//        }
//        stack.push(num+"");
//    }
//    public int getNum(Stack<String> stack){
//        int num=0,R=0;
//        String f = "+";
//        while (!stack.empty()){
//            num = Integer.parseInt(stack.get(0));
//            stack.remove(0);
//            R = "+".equals(f)?(R+num):(R-num);
//            if (!stack.empty()){
//                f = stack.get(0);
//                stack.remove(0);
//            }
//        }
//        return R;
//    }
//    public int[] getValue(String str,int i){
//        Stack<String> Q = new Stack<>();
//        int pre = 0;
//        while (i < str.length() && ')' != str.charAt(i)){
//            char c = str.charAt(i);
//            if (c >= '0' && c <= '9'){
//                pre = 10 * pre + (c - '0');
//                i++;
//            }else if (c != '('){
//                addNum(Q,pre);
//                Q.push(c + "");
//                pre = 0;
//                i++;
//            }else {
//                int[] bra = getValue(str,i+1);
//                pre = bra[0];
//                i = bra[1] +1;
//            }
//        }
//        addNum(Q,pre);
//        int[] R = new int[2];
//        R[0] = getNum(Q);
//        R[1] = i;
//        return R;
//    }
//    public static void main(String args[]){
//        Scanner s = new Scanner(System.in);
//        Eval eval = new Eval();
//        while (s.hasNext()) {
//            int[] R = eval.getValue(s.nextLine(),0);
//            System.out.println(R[0]);
//        }
//    }




    private static Set<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "*", "/", "(", ")"));

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        Stack<Character> operator = new Stack<>();
        while (s.hasNext()) {
            numbers.clear();
            operator.clear();
            String line = s.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            char last = ' ';
            for (char c : line.toCharArray()) {
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

            System.out.println(eval2(numbers));
        }
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



    // 超时
    public static void main3(String args[]){
        Scanner s = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        List<Character> operator = new ArrayList<>();
        while(s.hasNext()){
            numbers.clear();
            operator.clear();
            String line = s.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (char c:line.toCharArray()){
                if (c >= '0' && c <= '9'){
                    sb.append(c);
                    flag = true;
                }else {
                    if (flag){
                        numbers.add(Integer.valueOf(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    flag = false;
                    switch (c){
                        case '(':operator.add(c); break;
                        case '+':
                        case '-':
                            while (operator.size() > 0 &&
                                    operator.get(operator.size()-1) != '(' &&
                                    operator.get(operator.size()-1) != ' '){
                                eval(numbers,operator);
                            }
                            operator.add(c); break;
                        case '*':
                        case '/': operator.add(c); break;
                        case ')': while (eval(numbers,operator) != '('){}

                            break;
                        default:break;
                    }
                }
            }
            if (flag){
                numbers.add(Integer.valueOf(sb.toString()));
            }
            while (eval(numbers,operator) != ' '){
            }
            System.out.println(numbers.get(0));
        }
    }
    public static Character eval(List<Integer> numbers, List<Character> operator){
        int num_ = numbers.size();
        int op_ = operator.size();
        if (num_ == 1 || op_ == 0){
            return ' ';
        }
        Character op = operator.get(op_-1);
        switch (op){
            case '+': numbers.set(num_-2,numbers.get(num_-2) + numbers.get(num_-1));break;
            case '-': numbers.set(num_-2,numbers.get(num_-2) - numbers.get(num_-1));break;
            case '*': numbers.set(num_-2,numbers.get(num_-2) * numbers.get(num_-1));break;
            case '/': numbers.set(num_-2,numbers.get(num_-2) / numbers.get(num_-1));break;
            case '(': operator.remove(op_-1); return '(';
        }
        numbers.remove(num_-1);
        operator.remove(op_-1);
        return op;
    }
}
