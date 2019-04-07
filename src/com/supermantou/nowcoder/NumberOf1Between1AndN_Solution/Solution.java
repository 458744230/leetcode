package com.supermantou.nowcoder.NumberOf1Between1AndN_Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static long[] base = {0,1,20,300,4000,50000,600000,
            7000000,80000000,900000000};
    public static long[] power = {1,10,100,1000,10000,100000,1000000,
            10000000,100000000,1000000000};
    public int NumberOf1Between1AndN_Solution(int n) {
        int next,sum = 0;
        int now = 0;
        next = n;
        now = next % 10;
        if(now > 0){
            sum = 1;
        }
        next = next / 10;
        for(int i = 1;next != 0;i++){
            now = next % 10;
            if(now > 1){
                sum += power[i] + now * base[i];
            }else if(now == 1){
                sum += base[i] + (n % power[i] + 1);
            }
            next = next / 10;
        }
        return sum;
    }
    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.print(solution.NumberOf1Between1AndN_Solution(987654321));
    }
}
