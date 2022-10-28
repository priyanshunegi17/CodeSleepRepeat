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

// https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

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
       Node head1=reverse(first);
       Node head2=reverse(second);
       Node check1=head1;
       Node check2=head2;
       int carry=0;
       int sum=0;
       int val=0;
       
       Node head=new Node(-1);
       Node check=head;
    //   Node newNode=null;
       while(check1!=null || check2!=null){
           if(check1!=null && check2!=null){
               sum=check1.data+check2.data+carry;
               check1=check1.next;
               check2=check2.next;
           }
           else if(check1==null){
               sum=check2.data+carry;
               check2=check2.next;
           }
           else if(check2==null){
               sum=check1.data+carry;
               check1=check1.next;
           }
                val=sum%10;
               carry=sum/10;
               Node newNode=new Node(val);
                check.next=newNode;
                check=check.next;
       }
       if(carry>0){
           Node newNode=new Node(carry);
           check.next=newNode;
       }
       return reverse(head.next);
    }
}















