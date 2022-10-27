/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode check=head;
        while(check!=null){
            if(map.containsKey(check)){
                return check;
            }
            else{
                map.put(check,check.val);
            }
            check=check.next;
        }
        return null;
    }
}