//{ Driver Code Starts
//Initial template code for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            if( x.detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// we'll use slow and fast pointer...
// slow will move 1 position at a time...
// fast will move 2 position at a time...
// if they become equal.. it means the linked list is having a loop
// if they become null, it means there is no loop and we reached the end of the linked list.
class Solution {
    public static boolean detectLoop(Node head){
        Node fast=head.next;
        Node slow=head;
        // keep traversing until they reaches to end...
        while(fast!=null && fast.next!=null){
            // in case of loop.. at once they'll collide... so check for that scenario..    
            // if they becomes equal then it means there is a loop in the linked list
            if(slow==fast){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}