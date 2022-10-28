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
    void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
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
                System.out.println(left.val+" "+right.val);
                // curr.next=reverse(left,right);
                ListNode revHead=reverse(left,right);
                curr.next=revHead;
                curr=left;
                // System.out.println(right.next.val+" this ");
                // curr=right;
                // print(reverse(left,right));
                // ListNode cnt = revHead;
                // while(cnt.next!=null){
                    // cnt=cnt.next;
                // }
                // cnt.next=ceck.next;
                // System.out.println("checkdata+"+ref.val);
                left.next=ref;
                check=left;
                left=left.next;
            }
            check=check.next;
            i++;
        }
        // print(reverse(head,head.next));
        return newHead.next;
        // return head;
    }
    
    
    
    
}