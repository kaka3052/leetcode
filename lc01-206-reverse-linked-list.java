// 206. Reverse Linked List
// Easy
// Reverse a singly linked list.
// Example:
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:
// A linked list can be reversed either iteratively or recursively. Could you implement both?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //reverse a linked list. 
    //loop : and reset item.next
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        //traversal linked list
        while(curr != null){
            ListNode next = curr.next;
            // reset curr.next, from next note to prev node
            curr.next = prev;
            // reset prev , from prev to curr
            prev = curr;
            // make curr to next node
            curr = next;
        }
        // return the last one from loop
        return prev;
    }
}