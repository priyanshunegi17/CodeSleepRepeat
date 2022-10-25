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
        HashMap<ListNode,Integer> map = new HashMap<>();
        int idx=0;
        ListNode check=head;
        while(check!=null){
            if(map.containsKey(check)){
                return check;    
            }
            else{
                map.put(check,idx);
            }
            idx++;
            check=check.next;
        }
            return null;
    }
}