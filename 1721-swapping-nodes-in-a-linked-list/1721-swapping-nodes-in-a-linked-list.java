/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// move fast pointer upto k'th position from beginning.. and save this in the left node..
// then move both slow and fast pointer until fast reaches null
// once fast becomes null.. the slow would be pointing to the n'th node from the end
// now we can swap values of both the left and right nodes..

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow=head;
        ListNode fast=head;
        int i=1;
        while(i!=k && fast!=null){
            fast=fast.next;
            i++;
        }
        ListNode left=fast;
        ListNode right=null;        
        while(fast!=null){
            right=slow;
            slow=slow.next;
            fast=fast.next;
        }
        // swap the values of left and right node...
        int temp= left.val;
        left.val=right.val;
        right.val=temp;
        
        return head;
    }
}