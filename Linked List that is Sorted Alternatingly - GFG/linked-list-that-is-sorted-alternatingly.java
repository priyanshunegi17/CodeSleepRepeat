//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
    Node mergeTwoSortedLists(Node head1, Node head2){
        if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        if(head1.data<=head2.data){
            head1.next=mergeTwoSortedLists(head1.next,head2);
            return head1;
        }
        else{
            head2.next=mergeTwoSortedLists(head1,head2.next);
            return head2;
        }
    }   
    Node findMid(Node head){
        Node fast=head;
        Node slow=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        return slow;
    }
    
   public Node sort(Node head){
       if(head==null || head.next==null){
           return head;
       }
       
        Node mid= findMid(head);
        Node left=head;
        Node right=mid;
        
        left = sort(left);
        right= sort(right);
        return mergeTwoSortedLists(left,right);
    }
}















