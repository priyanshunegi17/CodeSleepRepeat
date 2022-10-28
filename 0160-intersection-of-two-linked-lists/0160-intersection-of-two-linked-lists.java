// https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// approch: codeWithAlisha / TakeUForward
// start traversing from the head of both linkedlist. 
// if any pointer reaches to the null. move that pointer to the head of other linked list.
// in this way, both the pointers will meet at once.. and return that node.
// if any of the pointer again reaches null. it means there is no intersection. so return null
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode check1=headA;
        ListNode check2=headB;
        Boolean once=false;
        while(check1!=check2){
            check1=check1.next;
            check2=check2.next;
            if(check1==null){
                if(once){
                    return null;
                }
                check1=headB;
                once=true;
            }
            if(check2==null){
                check2=headA;
            }
        }
        return check1;
        
    }
}