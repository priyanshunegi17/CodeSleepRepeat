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
        // System.out.println(left.val+" "+right.val);
        // System.out.println(right.val);
        
        int temp= left.val;
        left.val=right.val;
        right.val=temp;
        
        return head;
    }
}