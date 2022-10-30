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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode curr=newHead;
        // ListNode check1=list1;
        // ListNode check2=list2;
        while(list1!=null || list2!=null){
            ListNode newNode = null;
            if(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    newNode=new ListNode(list1.val);
                    curr.next=newNode;
                    list1=list1.next;
                }   
                else{
                    newNode=new ListNode(list2.val);
                    curr.next=newNode;
                    list2=list2.next;
                }
            }
            else if(list1==null){
                curr.next=list2;
                break;
            }
            else if(list2==null){
                curr.next=list1;
                break;
            }
            curr=curr.next;
        }
        return newHead.next;
    }
}