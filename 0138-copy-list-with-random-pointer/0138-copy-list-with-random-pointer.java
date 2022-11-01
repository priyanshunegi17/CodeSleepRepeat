/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node check=head,nex=head.next;
        //build the deep copy...
        while(check!=null){
            Node newNode= new Node(check.val);
            newNode.next=check.next;
            check.next=newNode;
            check=newNode.next;
        }
        
        // maintain the random pointers...
        check=head;
        while(check!=null){
            if(check.random!=null){
                check.next.random=check.random.next;
            }
            check=check.next.next;
        }
        
        // detach...
        Node newHead = new Node(-1);
        Node tail=newHead;
        check=head;
        while(check!=null){
            tail.next=check.next;
            tail=tail.next;
            check.next=tail.next;
            check=check.next;
        }
        return newHead.next;
    }
}











