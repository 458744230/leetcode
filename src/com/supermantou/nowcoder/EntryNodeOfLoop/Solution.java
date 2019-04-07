package com.supermantou.nowcoder.EntryNodeOfLoop;


public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode way1 = pHead, way2 = pHead;
        while (way1 != null && way2 != null && way1 != way2) {
            way1 = way1.next;
            if (way2.next == null) {
                return null;
            }
            way2 = way2.next.next;
        }
        if (way1 == null || way2 == null) {
            return null;
        }
        way1 = pHead;
        while (way1 != way2) {
            way1 = way1.next;
            way2 = way2.next;
        }
        return way1;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.EntryNodeOfLoop(null);
    }
}
