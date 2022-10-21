//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
    } 
} 
   

// } Driver Code Ends

// https://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1
/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
// first find the position of the mid element....
// once we got the position, then we just need to traverse upto that position and delete
// the node at "curr" position...
class Solution {
    Node deleteMid(Node head) {
      Node check = head;
      int count=0;
      // count the elements..
      while(check!=null){
          count++;
          check=check.next;
      }
      // get the mid position...
      int k=(count/2)+1;
      
      int i=1;
      
      Node prev=null;
      Node curr=head;
      while(i!=k){
          prev=curr;
          curr=curr.next;
          i++;
      }
    prev.next=curr.next;
    curr.next=null;
      
      return head;
    }
}





