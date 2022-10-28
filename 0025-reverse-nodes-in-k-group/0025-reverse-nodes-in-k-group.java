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
    ListNode reverse(ListNode head,ListNode end){
        if(head==end || head.next==null){
            return head;
        }    
        ListNode newHead=reverse(head.next,end);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int i=1;
        ListNode left=head;
        ListNode right=head;
        ListNode check=head;
        ListNode newHead = new ListNode(0);
        ListNode curr=newHead;
        while(check!=null){
            if(i%k==0){
                ListNode ref=check.next;
                right=check;
                curr.next=reverse(left,right);
                curr=left;
                left.next=ref;
                check=left;
                left=left.next;
            }
            check=check.next;
            i++;
        }
        return newHead.next;
    }
    
    
    
    
}