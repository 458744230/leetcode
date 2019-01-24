package com.supermantou.leetcode.algorithms.addTwoNumbers;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        int flag = 0;
        while (l1 != null && l2 !=null){
            int value = l1.val + l2.val + flag;
            if (value >= 10){
                flag = 1;
                value -= 10;
            }else {
                flag = 0;
            }
            p.next = new ListNode(value);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 !=null){
            p.next = l1;
        }else {
            p.next = l2;
        }
        if (p.next != null){

            p = p.next;
            while (flag == 1 & p!= null){
                    if(p.val == 9){
                        p.val = 0;
                        if(p.next == null){
                            p.next = new ListNode(1);
                            return root.next;
                        }
                        p=p.next;
                    }else {
                        p.val++;
                        flag=0;
                        break;
                    }
            }
        }
        if (flag ==1){
            p.next = new ListNode(1);
        }
        return root.next;
    }
    public static void main(String []args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(1);
//        l2.next.next = new ListNode(5);
        ListNode l3 = new Solution().addTwoNumbers(l1,l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
