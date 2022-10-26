//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }    
        Node last = reverse(head.next);
        head.next.next=head;
        head.next=null;
        
        return last;
    }
    
    static Node addTwoLists(Node first, Node second){
        Node head1=first;
        Node head2 =second;
        head1= reverse(head1);
        head2= reverse(head2);
        int carry=0;
        Node head = new Node(0);
        Node curr=head;
        
        Node newNode = null;
        while(head1!=null || head2!=null){
            int sum=0,val=0;
            if(head1!=null && head2!=null){
                sum=head1.data+head2.data+carry;
                val=sum%10;
                carry=sum/10;
                // System.out.println(head1.data+" "+head2.data);
                head1=head1.next;
                head2=head2.next;
            }
            else if(head1==null){
                // System.out.println("null "+head2.data);
                sum=head2.data+carry;
                val=sum%10;
                carry=sum/10;
                head2=head2.next;
            }
            else{
                // System.out.println(head1.data+"null ");
                sum=head1.data+carry;
                val=sum%10;
                carry=sum/10;
                head1=head1.next;
            }
                newNode = new Node(val);
                curr.next=newNode;
                curr=curr.next;
                // System.out.print(val+"+");
        }
        if(carry>0){
            newNode= new Node(carry);
            curr.next=newNode;
        }
        return reverse(head.next);
    }
}















