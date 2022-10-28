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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
    	ListNode slow=head;
    	ListNode fast=head;
        ListNode prev=null;
        if(head.next==null){
            return null;
        }
    	while(i<n && fast!=null){
    	    fast=fast.next;
    	    i++;
    	}

    	while(fast!=null){
            prev=slow;
    	    slow=slow.next;
    	    fast=fast.next;
    	}
        if(prev==null){
            head=head.next;
        }
        else{
    	    prev.next=slow.next;
        }
        // System.out.println(prev);
        return head;
    }
}