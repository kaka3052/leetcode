// 25. Reverse Nodes in k-Group
// Hard

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// Example:

// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// Note:

// Only constant extra memory is allowed.
// You may not alter the values in the list's nodes, only nodes itself may be changed.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseGroup(null, head, k); 
    }
    
    public ListNode reverseGroup(ListNode prevFromLastGroup, ListNode head, int k){
        if (head == null){
            return null;
        }
        ListNode prev = prevFromLastGroup;
        ListNode cur = head;
        
        int i = 1;
        
        while(i <= k && cur != null){
            if (cur.next != null){
                if (i == k){//the kth node
                    head.next = cur.next;
                    reverseGroup(cur, cur.next, k);
                    return cur;
                }else{
                    ListNode next = cur.next;  
                    cur.next = prev;
                    prev = cur;
                    cur = next;              
                    i++;    
                }
            }              
        }
        if (i < k){
            return reverseGroup(prevFromLastGroup, prev, i);
        }else{
            return null;
        }
        
    }
}