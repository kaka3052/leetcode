// 24. Swap Nodes in Pairs
// Medium
// Given a linked list, swap every two adjacent nodes and return its head.
// Example:
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Note:
// Your algorithm should use only constant extra space.
// You may not modify the values in the list's nodes, only nodes itself may be changed.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode res = head.next;

        while(cur != null && cur.next != null){
            ListNode a = cur;
            ListNode b = cur.next;
            ListNode c = cur.next.next;

            //reverse a b
            a.next = c;
            b.next = a;
            // need deal with prev
            if(prev != null){
                prev.next = b;
            }
            prev = a;
            cur = c;
        }
        return res;        
    }
}